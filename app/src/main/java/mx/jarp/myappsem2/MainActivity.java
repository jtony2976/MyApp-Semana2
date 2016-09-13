package mx.jarp.myappsem2;

import android.app.Activity;
import android.app.AlertDialog;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import java.util.Calendar;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {

    Button datepickerdialogbutton;
    TextView selecteddate;

    private TextView fullname_2;
    private TextView textView1_2;
    private TextView telefono_2;
    private TextView email_2;
    private TextView descripcion_2;

    public final static String EXTRA_MESSAGE1 = "ejemplo1";
    public final static String EXTRA_MESSAGE2 = "ejemplo2";
    public final static String EXTRA_MESSAGE3 = "ejemplo3";
    public final static String EXTRA_MESSAGE4 = "ejemplo4";
    public final static String EXTRA_MESSAGE5 = "ejemplo5";

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datepickerdialogbutton = (Button) findViewById(R.id.button1);
        selecteddate = (TextView) findViewById(R.id.textView1);

        datepickerdialogbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DialogFragment dialogfragment = new DatePickerDialogClass();

                dialogfragment.show(getFragmentManager(), "Date Picker Dialog");

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //Recibiendo parametros o cachandolos
        Intent intent2 = getIntent();
        String message_1a = intent2.getStringExtra(DetalleContacto.EXTRA_MESSAGE1a);
        String message_2a = intent2.getStringExtra(DetalleContacto.EXTRA_MESSAGE2a);
        String message_3a = intent2.getStringExtra(DetalleContacto.EXTRA_MESSAGE3a);
        String message_4a = intent2.getStringExtra(DetalleContacto.EXTRA_MESSAGE4a);
        String message_5a = intent2.getStringExtra(DetalleContacto.EXTRA_MESSAGE5a);

        //Mostrando datos en los views de detalle de contacto
        fullname_2 = (TextView) findViewById(R.id.fullname);
        textView1_2 = (TextView) findViewById(R.id.textView1);
        telefono_2 = (TextView) findViewById(R.id.telefono);
        email_2 = (TextView) findViewById(R.id.email);
        descripcion_2 = (TextView) findViewById(R.id.descripcion);

        //Manipulando elementos - poniendo datos cachados o recibidos arriba
        fullname_2.setText(message_1a);
        textView1_2.setText(message_2a);
        telefono_2.setText(message_3a);
        email_2.setText(message_4a);
        descripcion_2.setText(message_5a);


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://mx.jarp.myappsem2/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://mx.jarp.myappsem2/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public static class DatePickerDialogClass extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
                    AlertDialog.THEME_DEVICE_DEFAULT_DARK, this, year, month, day);

            return datepickerdialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            TextView textview = (TextView) getActivity().findViewById(R.id.textView1);

            textview.setText(day + " / " + (month + 1) + " / " + year);

        }
    }

    /**
     * Called when the user clicks the Siguiente button
     */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DetalleContacto.class);

        //Vamos a guardar en variables cada objeto TextView que hay en el archivo xml por si id para despues accesar su texto
        TextView full_name = (TextView) findViewById(R.id.fullname);
        TextView fec_nac = (TextView) findViewById(R.id.textView1);
        TextView tel = (TextView) findViewById(R.id.telefono);
        TextView e_mail = (TextView) findViewById(R.id.email);
        TextView descrip = (TextView) findViewById(R.id.descripcion);

        //Jalamos el texto que tiene cada objeto TextView y lo guardamos en variables de tipo String
        String message1 = full_name.getText().toString();
        String message2 = fec_nac.getText().toString();
        String message3 = tel.getText().toString();
        String message4 = e_mail.getText().toString();
        String message5 = descrip.getText().toString();

        //Ponemos el valor de cada variable String en las variables EXTRA_MESSAGE que son publicas para
        //ser accesadas por el otro Activity
        intent.putExtra(EXTRA_MESSAGE1, message1);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        intent.putExtra(EXTRA_MESSAGE3, message3);
        intent.putExtra(EXTRA_MESSAGE4, message4);
        intent.putExtra(EXTRA_MESSAGE5, message5);

        startActivity(intent);
    }

    /**
     * Called when the user clicks the Limpiar Datos button
     */
    public void cleanDatos(View view) {
        //Vamos a guardar en variables cada objeto TextView que hay en el archivo xml por si id para despues accesar su texto
        TextView full_name = (TextView) findViewById(R.id.fullname);
        TextView fec_nac = (TextView) findViewById(R.id.textView1);
        TextView tel = (TextView) findViewById(R.id.telefono);
        TextView e_mail = (TextView) findViewById(R.id.email);
        TextView descrip = (TextView) findViewById(R.id.descripcion);

        full_name.setText(" ");
        fec_nac.setText(" ");
        tel.setText(" ");
        e_mail.setText(" ");
        descrip.setText(" ");

    }

}
