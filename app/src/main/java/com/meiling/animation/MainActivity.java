package com.meiling.animation;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.jump)
    TextView jump;
    @BindView(R.id.show)
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.jump, R.id.show})
    public void onClick(View views) {
        switch (views.getId()) {
            case R.id.jump:
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
//                overridePendingTransition(R.anim.fade, R.anim.hold);//淡出

//                overridePendingTransition(R.anim.push_left_out, R.anim.push_left_in);//划入

//                overridePendingTransition(R.anim.push_up_out, R.anim.push_up_in);// 上下划入

//                overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
                break;
            case R.id.show:
                final Dialog mDialogTemp = new Dialog(this, R.style.AlbumDialogStyle);
                View view = LayoutInflater.from(this).inflate(R.layout.dialog_common_confirm, null);
                TextView tv_title = (TextView) view.findViewById(R.id.tv_title);

                TextView tv_content = (TextView) view.findViewById(R.id.tv_content);

                TextView btn_cancel =  (TextView) view.findViewById(R.id.btn_cancel);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialogTemp.dismiss();
                    }
                });

                TextView btn_confirm =  (TextView) view.findViewById(R.id.btn_confirm);
                btn_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialogTemp.dismiss();
                    }
                });


                WindowManager.LayoutParams lp = mDialogTemp.getWindow().getAttributes();
                lp.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,260,getResources().getDisplayMetrics());
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.gravity = Gravity.CENTER;

                mDialogTemp.setContentView(view, lp);
                mDialogTemp.setCanceledOnTouchOutside(false);
                mDialogTemp.show();
                break;
        }
    }
}
