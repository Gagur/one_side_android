package com.guga.onside.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.guga.lib.inject.From;
import com.guga.lib.inject.InjectUtils;
import com.guga.onside.R;

import java.util.zip.Inflater;

/**
 * Created by pingfu on 16/2/29.
 */
public class ConfigDialog extends AlertDialog {
    @From(R.id.cbx_upload)
    private CheckBox cbxUpload;

    @From(R.id.cbx_download)
    private CheckBox cbxDownload;

    @From(R.id.edt_server)
    private EditText edtServer;

    private Button btnCommit;

    public ConfigDialog(Context context) {
        super(context);
        getWindow().setWindowAnimations(R.style.mDialogStyle);
    }

    private void setContentView() {
        View content = LayoutInflater.from(getContext()).inflate(R.layout.v_config_dialog, null);


        setContentView(content);
    }
}
