package com.jsf;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@Stateless
@ApplicationPath("/services")
public class SupplierApplication extends Application {
   private Set<Class<?>> singletons = new HashSet<Class<?>>();

   public SupplierApplication() {
      singletons.add(SupplierResource.class);
   }

   @Override
   public Set<Class<?>> getClasses() {
      return singletons;
   }
}
