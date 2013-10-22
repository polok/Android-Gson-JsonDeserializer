package com.learning.gsonexample;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcin on 09.10.13.
 */
public class Event {

    @SerializedName("g")
    private List<Cards> cards = new ArrayList<Cards>();

    private String value;

    public void addCard(Cards cards) {
        this.cards.add(cards);
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
