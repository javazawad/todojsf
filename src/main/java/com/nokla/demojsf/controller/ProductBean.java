package com.nokla.demojsf.controller;

import com.nokla.demojsf.entity.Manufacturer;
import com.nokla.demojsf.entity.Product;
import com.nokla.demojsf.service.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;

import java.util.List;

@Named
@RequestScoped
public class ProductBean {
    @Getter
    private Product product = new Product();

    @Getter
    private List<Manufacturer> manufacturers;

    @Inject
    private ProductService productService;

    @PostConstruct
    public void init(){
        try {
            manufacturers = productService.getManufacturers();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void saveProduct(){
        try{
            System.out.println(product);
            productService.create(product);
            FacesContext.getCurrentInstance().getExternalContext().redirect("hello.xhtml");
        } catch (Exception e){
            System.out.println(e.getMessage());
            FacesContext.getCurrentInstance().addMessage("productSubmitMessage",new FacesMessage("Product add error", e.getMessage()));
        }
    }

    public void printProduct(){
        System.out.println(product);
    }
}
