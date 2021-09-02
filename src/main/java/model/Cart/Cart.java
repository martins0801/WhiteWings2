package model.Cart;



import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;

    public Cart(ArrayList<CartItem> items) {
        this.items = items;
    }

    public double getTotaleCarrello(){
        double tot=0;
        for(int i=0;i<items.size();i++){
            tot=tot+items.get(i).getTotale();
        }
        return tot;
    }
}
