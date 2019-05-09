package graficos.curso.ejercicios.a11_escuchador_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.telephony.SmsMessage;

public class ReceptorSms extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("llega SMSSSSSSSSSSS ");
        String origen="";
        String textoSms="";
        //los SMS se envían en trozos que forman un array de objetos
        //el conjunto de trozos se llama pdus
        Object[] pdus=(Object[])intent.getExtras().get("pdus");
        //recorremos los trozos para montar el mensaje completo
        for(int i=0;i<pdus.length;i++){
            //obtenemos el objeto SmsMessage de cada pdu
            SmsMessage sm= SmsMessage.createFromPdu(
                    (byte[]) pdus[i],"3gpp");
            //recuperamos el número desde el que se
            //ha enviado el mensaje
            origen=sm.getOriginatingAddress();
            //recuperamos el texto de ese trozo de mensaje
            textoSms+= sm.getMessageBody().toString();
        }
        textoSms=origen+":"+textoSms;
        System.out.println("texto sms "+textoSms);
        Message m=new Message();
        m.obj=textoSms;

        MainActivity.manejador.sendMessage(m);
    }
}
