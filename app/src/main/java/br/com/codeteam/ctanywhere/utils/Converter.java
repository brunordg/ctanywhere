package br.com.codeteam.ctanywhere.utils;

import android.os.Build;
import android.telephony.PhoneNumberUtils;
import android.util.Log;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import static android.content.ContentValues.TAG;

/**
 * Created by Bruno Rodrigues e Rodrigues on 29/01/17.
 */

public class Converter {
    
    public static String toPhoneNumber(String phone, String ddd) {
        try {
            phone = PhoneNumberUtils.stripSeparators(phone);
            
            if (phone.length() == 8 || phone.length() == 9) {
                phone = ddd + phone;
            }
        
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                phone = PhoneNumberUtils.formatNumberToE164(phone, "BR");
            } else {
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(phone, "BR");
    
                phone = null;
                
                if (phoneNumberUtil.isValidNumberForRegion(phoneNumber, "BR")) {
                    phone = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
                }
            }
        
            if (null == phone) {
                return null;
            }
    
            phone = phone.replace("+55", "0");
            
        } catch (NumberParseException e) {
            Log.d(TAG, "toPhoneNumber: Erro ao formatar");
        }
        
        return phone;
    }
}
