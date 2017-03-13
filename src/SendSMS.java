
import infobip.api.client.SendSingleTextualSms;
import infobip.api.config.BasicAuthConfiguration;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.SMSResponseDetails;
import infobip.api.model.sms.mt.send.textual.SMSTextualRequest;
import java.util.Arrays;
import infobip.api.client.SendSingleTextualSms;
import infobip.api.config.BasicAuthConfiguration;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.SMSResponseDetails;
import infobip.api.model.sms.mt.send.textual.SMSTextualRequest;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author georgegeorgiades
 */
public class SendSMS {


/**
 * Created by milosmilakovic on 9/23/15.
 */

    public String orderNum="";
    public String contactNum="";
    public static final String BASE_URL = "https://api.infobip.com/";
    public static final String USERNAME = "Checkcleaners";
    public static final String PASSWORD = "Selibas0302";
   
    public static final String FROM = "CheckCleaners";

    public static final String NOTIFY_URL = "https://notify.com";
    
    public SendSMS (String cn, String on) {
        contactNum=cn;
        orderNum=on;
        String messageText = "Check Dry Cleaners\nThis is an automated notification to inform you that your order: "+orderNum+" is ready for collection.\nPlease note that we close at 5pm daily.\nFor further information, contact 0116403596. Thank you!";
        SendSingleTextualSms client = new SendSingleTextualSms(new BasicAuthConfiguration(USERNAME, PASSWORD));

        SMSTextualRequest requestBody = new SMSTextualRequest();
        requestBody.setFrom(FROM);
        requestBody.setTo(Arrays.asList(contactNum));
        requestBody.setText(messageText);

        SMSResponse response = client.execute(requestBody);

        SMSResponseDetails sentMessageInfo = response.getMessages().get(0);
        System.out.println("Message ID: " + sentMessageInfo.getMessageId());
        System.out.println("Receiver: " + sentMessageInfo.getTo());
        System.out.println("Message status: " + sentMessageInfo.getStatus().getName());
    }


}
