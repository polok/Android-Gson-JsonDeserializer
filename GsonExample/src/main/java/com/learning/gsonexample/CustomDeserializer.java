package com.learning.gsonexample;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by marcin on 09.10.13.
 * Json data can contain card object and array of objects
 */
public class CustomDeserializer implements JsonDeserializer<Event> {

    public static final String EVENT_CARD_TAG = "g";
    public static final String EVENT_VALUE_TAG = "value";

    @Override
    public Event deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        Event event = new Event();
        JsonObject obj = jsonElement.getAsJsonObject();
        event.setValue(obj.get(EVENT_VALUE_TAG).getAsString());

        if(obj.get(EVENT_CARD_TAG).isJsonArray()) {
            handleArray(event, obj.getAsJsonArray(EVENT_CARD_TAG), jsonDeserializationContext);
        } else if(obj.get(EVENT_CARD_TAG).isJsonObject()) {
            handleObject(event, obj.get(EVENT_CARD_TAG).getAsJsonObject(), jsonDeserializationContext);
        }

        return event;
    }

    private void handleArray(Event e, JsonArray json, JsonDeserializationContext context) {
        Object[] array = new Object[json.size()];
        for(int i = 0; i < json.size(); i++) {
            Cards f = context.deserialize(json.get(i), Cards.class);
            e.addCard(f);
        }
    }

    private void handleObject(Event e, JsonObject json, JsonDeserializationContext context) {
        Cards f = context.deserialize(json, Cards.class);
        e.addCard(f);
    }
}
