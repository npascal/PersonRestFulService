package org.pascalot.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

/**
 * Created by hamisu on 12/2/15.
 */
public class Refresh
{
    public String refreshUrl;
    public String refreshStatement = "";
    public String toggleLink;

    static final String REFRESH_COOKIE_NAME = "personService-refresh";
    static final String REFRESH_PARAMETER = "refresh";


    public Refresh(String refreshUrl, int seconds, HttpServletRequest request, HttpServletResponse response)
    {
        this.refreshUrl = refreshUrl;
        Cookie refreshCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (REFRESH_COOKIE_NAME.equals(cookie.getName()))
                {
                    refreshCookie = cookie;
                    break;
                }
            }
        }

        if (refreshCookie == null)
        {
            refreshCookie = new Cookie(REFRESH_COOKIE_NAME, "yes");
        }

        String refreshCommand = request.getParameter(REFRESH_PARAMETER);
        if (refreshCommand != null)
        {
            refreshCookie.setValue(refreshCommand);
        }


        String baseLinkHref = refreshUrl;
        if(baseLinkHref.contains("?"))
        {
            baseLinkHref += "&"; // append the refresh command
        }
        else
        {
            baseLinkHref += "?"; // refresh command is sole parameter.
        }

        boolean shouldRefresh = isTrue(refreshCookie.getValue());
        if (shouldRefresh)
        {
            refreshStatement = MessageFormat.format("<meta http-equiv=\"refresh\" content=\"{1};url={0}\"/>", refreshUrl,
                    seconds);

            toggleLink =MessageFormat.format("<a href=''{0}refresh=no''>Stop Refresh</a>", baseLinkHref);
        }
        else
        {
            refreshStatement = "";
            toggleLink =MessageFormat.format("<a href=''{0}refresh=yes''>Auto Refresh</a>", baseLinkHref);
        }
        response.addCookie(refreshCookie);
    }

    public Refresh(String refreshUrl, HttpServletRequest request, HttpServletResponse response)
    {
        this(refreshUrl, 3, request, response);
    }


    public String getRefreshStatement()
    {
        return refreshStatement;
    }


    public String getToggleLink()
    {
        return toggleLink;
    }


    public String getStatements()
    {
        return getRefreshStatement() + "\n" + getToggleLink();
    }

    public boolean isTrue(String value) {
        if(value != null && value.length() != 0) {
            char ch = Character.toLowerCase(value.charAt(0));
            if(value.length() > 1 && Character.isDigit(ch)) {
                try {
                    if(Long.parseLong(value) > 0L) {
                        return true;
                    }
                } catch (NumberFormatException var3) {
                    ;
                }
            }

            return "0fn".indexOf(ch) == -1;
        } else {
            return false;
        }
    }

}
