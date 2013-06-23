package net.android.icm;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnCalcular;
    private EditText edPeso;
    private EditText edAltura;
    private TextView txtICM;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Cargar los componetes de diseño en  menoria para poder operar con ellos
        this.btnCalcular=(Button)findViewById(R.id.btnCalcular);
        this.edPeso=(EditText)findViewById(R.id.edPeso);
        this.edAltura=(EditText)findViewById(R.id.edAltura);
        this.txtICM=(TextView)findViewById(R.id.txtICM);

        //Metodo-->Poner a escuchar al boton
        this.btnCalcular.setOnClickListener(this);
    }
    //Recoger eventos del boton

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case (R.id.btnCalcular):
                //Quiere decir que se ha pulsado el boton calcular
                calcularICM();
                break;
        }

    }

    public void calcularICM()
    {
        try{
        String sAltura = this.edAltura.getText().toString();
        String sPeso = this.edPeso.getText().toString();

        if((sAltura!="") && (sPeso!=""))
        {
            Float altura = Float.parseFloat(sAltura);
            Float peso = Float.parseFloat(sPeso);
            Float resultado = (float)(peso/Math.pow((altura/100),2));

            //Añadir al txtICM
            this.txtICM.append(" "+ resultado);
            this.edAltura.setText("");
            this.edPeso.setText("");
        }
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }



    }


    
}
