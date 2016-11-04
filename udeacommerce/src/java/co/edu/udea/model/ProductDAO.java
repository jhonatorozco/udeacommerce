/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.model;

import co.edu.udea.entity.Products;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 *
 * @author estudiantelis
 */
public class ProductDAO {
    public List<Products> getAll(){
        Session session=null;
        List<Products> list=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            Query query=session.createQuery("from Products");
            list=(List<Products>)query.list();
            
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }finally{
            if (session!=null){
                session.close();            }
        }
        return list;
    }
    
}
