package blaash.gaming.mobile.urlmodule;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class BlaashSDK {

    private String portal_CustomerId;
    private String emailId;
    private String primaryPhoneNumber;
    private  String facebookId;
    private String first_name;
    private String last_name;


  public void initialize(String portal_CustomerId, String emailId, String facebookId, String primaryPhoneNumber,
                           String loggedIn_Customer_first_name, String loggedIn_Customer_last_name) {

        this.portal_CustomerId= portal_CustomerId;
        this.emailId = emailId;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.first_name = loggedIn_Customer_first_name;
        this.last_name = loggedIn_Customer_last_name;
        this.facebookId = facebookId;
    }

    private BlaashEvents InitialiseBlaashEvents()
    {
        BlaashEvents blaashEvents;
        blaashEvents =new BlaashEvents(portal_CustomerId,emailId,facebookId,primaryPhoneNumber,first_name,last_name);
        blaashEvents.setEvent_info(new ArrayList<>());
        return blaashEvents;
    }

    private void prepareEventAndSend(Event_information eventData)
    {
        try
        {
            BlaashEvents customerEventToSend = InitialiseBlaashEvents();
            List<Event_information> customer_events = new ArrayList<>();
            customer_events.add(eventData);
            customerEventToSend.setEvent_info(customer_events);

            Dispatch messageDispatcher = new Dispatch();
            messageDispatcher.dispatch(customerEventToSend);
        }
        catch (Exception ignored) {}
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notifyCartChanges(boolean isCartAdded, Product cartProduct, String cartGrossTotal, String quantityAddedOrRemoved)
    {
        try
        {
            Event_information cartInformation = EventProcessor.eventDataFormatter(isCartAdded ? Constants.ADD_TO_CART : Constants.REMOVE_FROM_CART,
                    cartProduct,cartGrossTotal,quantityAddedOrRemoved);
            prepareEventAndSend(cartInformation);
        } catch (Exception ignored) {}
    }

    public void notifySignUp(Customer customer)
    {
        try
        {
            Event_information customer_eventData = EventProcessor.eventDataFormatter(customer);
            prepareEventAndSend(customer_eventData);
        }
        catch (Exception ignored) {}
    }

    public void notifyReview(ProductReviewRequest reviewRequest)
    {
        try
        {
            Event_information customer_eventData = EventProcessor.eventDataFormatter(reviewRequest);
            prepareEventAndSend(customer_eventData);
        }
        catch (Exception ignored) {}
    }

    public void notifyWishList(Product product)
    {
        try
        {
            Event_information customer_eventData = EventProcessor.eventDataFormatter(product);
            prepareEventAndSend(customer_eventData);
        }
        catch (Exception ignored) {}
    }

    public void notifySearch(ProductSearchRequest searchRequest)
    {
        try
        {
            Event_information customer_eventData = EventProcessor.eventDataFormatter(searchRequest);
            prepareEventAndSend(customer_eventData);
        }
        catch (Exception ignored) {}
    }

    public void notifyProductView(ProductViewRequest productViewRequest)
    {
        try
        {
            Event_information customer_eventData = EventProcessor.eventDataFormatter(productViewRequest);
            prepareEventAndSend(customer_eventData);
        }
        catch (Exception ignored) {}
    }

    public void notifyCustomerOrder(CustomerOrder customerOrder)
    {
        try
        {
            Event_information customer_eventData = EventProcessor.eventDataFormatter(customerOrder);
            prepareEventAndSend(customer_eventData);
        }
        catch (Exception ignored) {}
    }
}
