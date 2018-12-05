package com.jsf;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class SupplierApplication extends Application {
   private Set<Object> singletons = new HashSet<Object>();

   public SupplierApplication() {
      singletons.add(new SupplierResource());
   }

   @Override
   public Set<Object> getSingletons() {
      return singletons;
   }
}
