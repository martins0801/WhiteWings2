package model.Cart;

import model.Dolci.Dolci;

public class CartItem {
    private final Dolci prodotto;
    private final String descrizione;
    private int quantità;

    public CartItem(double peso, Dolci prodotto, String descrizione, int quantità) {
        this.prodotto = prodotto;
        this.descrizione=descrizione;
        this.quantità=quantità;
    }


    public Dolci getProdotto() {
        return prodotto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getTotale(){
        return prodotto.getPrezzoAlKg()*prodotto.getPeso()*quantità;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
}
