package br.anderson.infnet.apppetfriendspedidotp3.events;

public class BaseEvent<T> {

    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
