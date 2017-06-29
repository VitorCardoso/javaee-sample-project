package pt.vcyst.proj.api;

import javax.ejb.Stateless;

@Stateless
public class Service {

    public String invoke() {
        return ": " + System.currentTimeMillis();
    }

}
