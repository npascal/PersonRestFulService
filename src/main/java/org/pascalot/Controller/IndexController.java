package org.pascalot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hamisu on 12/2/15.
 */
@Controller
public class IndexController
{
    @RequestMapping(value = "index.form", method = RequestMethod.GET)
    public String getIndexJSP(ModelMap model)
    {
        model.addAttribute("message", "Displaying the Index.jsp page");
        return "index";
    }
}
