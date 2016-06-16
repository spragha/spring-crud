package com.spragha.bankacc.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spragha.bankacc.model.Customer;
import com.spragha.bankacc.service.BankService;

@Controller
@SessionAttributes(types = Customer.class)
public class CustomerController {
	
	private final BankService bankService;

    @Autowired
    public CustomerController(BankService bankService) {
        this.bankService = bankService;
    }
    
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    
    @RequestMapping(value = "/customer/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        return "customer/createOrUpdateCustomerForm";
    }

    @RequestMapping(value = "/customer/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid Customer customer, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "customer/createOrUpdateCustomerForm";
        } else {
            this.bankService.saveCustomer(customer);
            status.setComplete();
            return "redirect:/customer/" + customer.getId();
        }
    }
    

    @RequestMapping(value = "/customer/find", method = RequestMethod.GET)
    public String initFindForm(Map<String, Object> model) {
        model.put("customer", new Customer());
        return "customer/findCustomer";
    }
    
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String processFindForm(Customer customer, BindingResult result, Map<String, Object> model) {

        // allow parameterless GET request for /owners to return all records
        if (customer.getLastName() == null) {
        	customer.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        Collection<Customer> results = this.bankService.findCustomerByLastName(customer.getLastName());
        if (results.size() < 1) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "customer/findCustomer";
        }
        if (results.size() > 1) {
            // multiple owners found
            model.put("selections", results);
            return "customer/customerList";
        } else {
            // 1 owner found
        	customer = results.iterator().next();
            return "redirect:/customer/" + customer.getId();
        }
    }
    
    
    @RequestMapping(value = "/customer/{customerId}/edit", method = RequestMethod.GET)
    public String initUpdateCustomerForm(@PathVariable("customerId") int customerId, Model model) {
        Customer customer = this.bankService.findCustomerById(customerId);
        model.addAttribute(customer);
        return "customer/createOrUpdateCustomerForm";
    }

    @RequestMapping(value = "/customer/{customerId}/edit", method = RequestMethod.PUT)
    public String processUpdateCustomerForm(@Valid Customer customer, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "customer/createOrUpdateCustomerForm";
        } else {
            this.bankService.saveCustomer(customer);
            status.setComplete();
            return "redirect:/customer/{customerId}";
        }
    }
    
    @RequestMapping("/customer/{customerId}")
    public ModelAndView showCustomer(@PathVariable("customerId") int customerId) {
        ModelAndView mav = new ModelAndView("customer/customerDetails");
        mav.addObject(this.bankService.findCustomerById(customerId));
        return mav;
    }

	
}
