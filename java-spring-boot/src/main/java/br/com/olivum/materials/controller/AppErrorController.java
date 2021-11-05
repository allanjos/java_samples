package br.com.olivum.materials.controller;

import br.com.olivum.materials.protocol.RequestResponse;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

/**
 * Basic Controller which is called for unhandled errors
 */
@ApiIgnore
@Controller
public class AppErrorController implements ErrorController {
    /**
     * Error Attributes in the Application
     */
    private ErrorAttributes errorAttributes;

    private final static String ERROR_PATH = "/error";

    /**
     * Controller for the Error Controller
     *
     * @param errorAttributes
     */
    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletResponse response) {
        int status = response.getStatus();

        response.setContentType("application/json");

        if (status == HttpStatus.NOT_FOUND.value()) {
            System.out.println("Error with code " + status);

            try {
                RequestResponse requestResponse = new RequestResponse();

                requestResponse.setMessage("message");
                requestResponse.setData("data");
                requestResponse.setStatus(404);


                new MappingJackson2HttpMessageConverter().write(requestResponse,
                                                                MediaType.APPLICATION_JSON,
                                                                new ServletServerHttpResponse(response));
            } catch(Exception e) {
                System.err.println("Error while serializing to JSON string.");
            }

            return null;
        }
        else if (status == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            System.out.println("Error with code " + status);

            try {
                RequestResponse requestResponse = new RequestResponse();

                requestResponse.setMessage("message");
                requestResponse.setData("data");
                requestResponse.setStatus(500);

                new MappingJackson2HttpMessageConverter().write(requestResponse,
                                                                MediaType.APPLICATION_JSON,
                                                                new ServletServerHttpResponse(response));
            } catch(Exception e) {
                System.err.println("Error while serializing to JSON string.");
            }

            return null;
        }

        System.out.println(status);

        try {
            RequestResponse requestResponse = new RequestResponse();

            requestResponse.setMessage("message");
            requestResponse.setData("data");
            requestResponse.setStatus(-1);

            new MappingJackson2HttpMessageConverter().write(requestResponse,
                                                            MediaType.APPLICATION_JSON,
                                                            new ServletServerHttpResponse(response));
        } catch(Exception e) {
            System.err.println("Error while serializing to JSON string.");
        }

        return null;
    }
}