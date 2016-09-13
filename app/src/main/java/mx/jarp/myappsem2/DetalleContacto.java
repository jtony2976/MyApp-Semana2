package mx.jarp.myappsem2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre_2;
    private TextView tvFecNac_2;
    private TextView tvTel_2;
    private TextView tvEmail_2;
    private TextView tvDescrip_2;

    public final static String EXTRA_MESSAGE1a = "ejemplo1";
    public final static String EXTRA_MESSAGE2a = "ejemplo2";
    public final static String EXTRA_MESSAGE3a = "ejemplo3";
    public final static String EXTRA_MESSAGE4a = "ejemplo4";
    public final static String EXTRA_MESSAGE5a = "ejemplo5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_contacto);


        //Recibiendo parametros o cachandolos
        Intent intent = getIntent();
        String message_1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String message_2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String message_3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String message_4 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        String message_5 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE5);

        //Mostrando datos en los views de detalle de contacto
        tvNombre_2 = (TextView) findViewById(R.id.tvNombre2);
        tvFecNac_2 = (TextView) findViewById(R.id.tvFecNac2);
        tvTel_2 = (TextView) findViewById(R.id.tvTel2);
        tvEmail_2 = (TextView) findViewById(R.id.tvEmail2);
        tvDescrip_2 = (TextView) findViewById(R.id.tvDescrip2);

        //Manipulando elementos - poniendo datos cachados o recibidos arriba
        tvNombre_2.setText(message_1);
        tvFecNac_2.setText(message_2);
        tvTel_2.setText(message_3);
        tvEmail_2.setText(message_4);
        tvDescrip_2.setText(message_5);

    }

    /**
     * Called when the user clicks the Siguiente button
     */
    public void editDatos(View view) {
        // Do something in response to button
        Intent intent2 = new Intent(this, MainActivity.class);

        //Vamos a guardar en variables cada objeto TextView que hay en el archivo xml por si id para despues accesar su texto
        TextView full_name = (TextView) findViewById(R.id.tvNombre2);
        TextView fec_nac = (TextView) findViewById(R.id.tvFecNac2);
        TextView tel = (TextView) findViewById(R.id.tvTel2);
        TextView e_mail = (TextView) findViewById(R.id.tvEmail2);
        TextView descrip = (TextView) findViewById(R.id.tvDescrip2);

        //Jalamos el texto que tiene cada objeto TextView y lo guardamos en variables de tipo String
        String message1 = full_name.getText().toString();
        String message2 = fec_nac.getText().toString();
        String message3 = tel.getText().toString();
        String message4 = e_mail.getText().toString();
        String message5 = descrip.getText().toString();

        //Ponemos el valor de cada variable String en las variables EXTRA_MESSAGE que son publicas para
        //ser accesadas por el otro Activity
        intent2.putExtra(EXTRA_MESSAGE1a, message1);
        intent2.putExtra(EXTRA_MESSAGE2a, message2);
        intent2.putExtra(EXTRA_MESSAGE3a, message3);
        intent2.putExtra(EXTRA_MESSAGE4a, message4);
        intent2.putExtra(EXTRA_MESSAGE5a, message5);

        startActivity(intent2);
    }

}
