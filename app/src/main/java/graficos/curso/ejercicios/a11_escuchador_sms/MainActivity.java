package graficos.curso.ejercicios.a11_escuchador_sms;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tvMensaje;
    public static Handler manejador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMensaje=this.findViewById(R.id.tvMensaje);
        manejador=new Handler(){
            @Override
            public void handleMessage(Message msg) {
               String mensaje=(String) msg.obj;
                tvMensaje.setText(mensaje);
            }
        };
    }
}
