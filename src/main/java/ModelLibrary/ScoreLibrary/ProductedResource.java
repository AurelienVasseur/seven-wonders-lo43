/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLibrary.ScoreLibrary;

import EnumLibrary.Resource;

/**
 *
 * @author Hicham
 */
public class ProductedResource {
    private Resource resource;
    private int quantity;

    public ProductedResource() {
    }

    public ProductedResource(Resource resource, int quantity) {
        this.resource = resource;
        this.quantity = quantity;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductedResource{" + "resource=" + resource + ", quantity=" + quantity + '}';
    }
    
    
}
