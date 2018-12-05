package com.jsf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.restfully.shop.domain.Customer;






@Path("/supplier")
public class SupplierResource {
    
    SupplierManager sm = new SupplierManager();
    private AtomicInteger idCounter = new AtomicInteger();

    public SupplierResource() {
    }
    
    @POST
    @Consumes("application/xml")
    public Response createCustomer(InputStream is) {
        System.out.println("Create Supplier");
        Supplier s = readSupplier(is);
        
        return Response.created(URI.create("/supplier/" + s.getId())).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/xml")
    public StreamingOutput getSupplier(@PathParam("id") int id) {
        Supplier customer = sm.find(id);
        if (customer == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
         }
         return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
               outputSupplier(outputStream, customer);
            }
         };
    }
    
    protected void outputSupplier(OutputStream os, Supplier cust) throws IOException {
        System.out.println("Output Supplier");
        PrintStream writer = new PrintStream(os);
        writer.println("<supplier id=" + cust.getId() + ">");
        writer.println("   <address>" + cust.getAddress() + "</address>");
        writer.println("   <city>" + cust.getCity() + "</city>");
        writer.println("   <contactName>" + cust.getContactName() + "</contactName>");
        writer.println("   <contactTitle>" + cust.getContactTitle() + "</contactTitle>");
        writer.println("   <country>" + cust.getCountry() + "</country>");
        writer.println("   <supplierName>" + cust.getSupplierName() + "</supplierName>");
        writer.println("   <postalCode>" + cust.getPostalCode() + "</postalCode>");
        writer.println("   <phoneNumber>" + cust.getPhoneNumber() + "</phoneNumber>");
        writer.println("</supplier>");
     }
    
    protected Supplier readSupplier(InputStream is) {
        try {
           DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
           Document doc = builder.parse(is);
           Element root = doc.getDocumentElement();
           Supplier cust = new Supplier();
           if (root.getAttribute("id") != null && !root.getAttribute("id").trim().equals(""))
              cust.setId(Integer.valueOf(root.getAttribute("id")));
           NodeList nodes = root.getChildNodes();
           for (int i = 0; i < nodes.getLength(); i++) {
              Element element = (Element) nodes.item(i);
              if (element.getTagName().equals("address")) {
                 cust.setAddress(element.getTextContent());
              }
              else if (element.getTagName().equals("city")) {
                 cust.setCity(element.getTextContent());
              }
              else if (element.getTagName().equals("contactName")) {
                 cust.setContactName(element.getTextContent());
              }
              
              else if (element.getTagName().equals("contactTitle")) {
                 cust.setContactTitle(element.getTextContent());
              }
              else if (element.getTagName().equals("country")) {
                 cust.setCountry(element.getTextContent());
              }
              else if (element.getTagName().equals("supplierName")) {
                 cust.setSupplierName(element.getTextContent());
              }
              else if (element.getTagName().equals("postalCode")) {
                  cust.setPostalCode(element.getTextContent());
               }
              else if (element.getTagName().equals("phoneNumber")) {
                  cust.setPhoneNumber(element.getTextContent());
               }
           }
           return cust;
        }
        catch (Exception e) {
           throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
     }
    
}
