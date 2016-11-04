/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.controller;

import co.edu.udea.entity.Products;
import co.edu.udea.model.ProductDAO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author estudiantelis
 */
@ManagedBean(name="productController")
public class ProductController {
    private List<Products> list= new ArrayList<Products>();
    
   
    public ProductController() {
    }
    
    public List<Products> getList(){
        ProductDAO productDAO=new ProductDAO();
        return productDAO.getAll();
    }
    
    public void setList(List<Products> l){
        this.list=l;
    }
    
    
    
}
