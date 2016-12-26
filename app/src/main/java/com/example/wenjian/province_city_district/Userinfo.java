package com.example.wenjian.province_city_district;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Wenjian on 2016/12/7.
 */

public class Userinfo extends AppCompatActivity {

    @InjectView(R.id.userinfo_rel_touxiang)
    RelativeLayout userinfoRelTouxiang;
    @InjectView(R.id.userinfo_nicheng)
    TextView userinfoNicheng;
    @InjectView(R.id.userinfo_rel_nicheng)
    RelativeLayout userinfoRelNicheng;
    @InjectView(R.id.userinfo_sex)
    TextView userinfoSex;
    @InjectView(R.id.userinfo_rel_sex)
    RelativeLayout userinfoRelSex;
    @InjectView(R.id.userinfo_britn)
    TextView userinfoBritn;
    @InjectView(R.id.userinfo_rel_brith)
    RelativeLayout userinfoRelBrith;
    @InjectView(R.id.userinfo_address)
    TextView userinfoAddress;
    @InjectView(R.id.userinfo_rel_address)
    RelativeLayout userinfoRelAddress;
    @InjectView(R.id.userinfo_profession)
    TextView userinfoProfession;
    @InjectView(R.id.userinfo_rel_profession)
    RelativeLayout userinfoRelProfession;
    @InjectView(R.id.userinfo_educational)
    TextView userinfoEducational;
    @InjectView(R.id.userinfo_rel_educational)
    RelativeLayout userinfoRelEducational;
    @InjectView(R.id.userinfo_worship)
    TextView userinfoWorship;
    @InjectView(R.id.userinfo_rel_worship)
    RelativeLayout userinfoRelWorship;

    String userSex = "男";
    String usereducation="小学";
    AlertDialog.Builder builder;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.userinfo_rel_touxiang, R.id.userinfo_rel_nicheng, R.id.userinfo_rel_sex, R.id.userinfo_rel_brith, R.id.userinfo_rel_address, R.id.userinfo_rel_profession, R.id.userinfo_rel_educational})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.userinfo_rel_touxiang:
                break;
            case R.id.userinfo_rel_nicheng:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("修改昵称");
                final EditText editText=new EditText(this);
                editText.setSingleLine();
                builder.setView(editText);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userinfoNicheng.setText(editText.getText().toString());
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(true);
                dialog=builder.create();
                dialog.setCanceledOnTouchOutside(true);
                builder.show();
                break;
            case R.id.userinfo_rel_sex:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("请选择您的性别");
                final String[] sex = new String[]{"男", "女"};
                builder.setSingleChoiceItems(sex, 2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userSex = sex[which];
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userinfoSex.setText(userSex);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(true);
                dialog=builder.create();
                dialog.setCanceledOnTouchOutside(true);
                builder.show();
                break;
            case R.id.userinfo_rel_brith:
                Calendar calendar=Calendar.getInstance();
                new FirstDatePickerDialog(Userinfo.this, 0, new FirstDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear, int startDayOfMonth) {
                        String textString = String.format(
                                "%d-%d-%d",startYear, startMonthOfYear + 1,startDayOfMonth);
                        userinfoBritn.setText(textString);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),true).show();
            break;
            case R.id.userinfo_rel_address:
                break;
            case R.id.userinfo_rel_profession:
                break;
            case R.id.userinfo_rel_educational:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("请选择您的教育程度");
                final String[] education = new String[]{"小学", "初中","高中","本科","硕士","博士"};
                builder.setSingleChoiceItems(education, 6, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        usereducation=education[which];
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userinfoEducational.setText(usereducation);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(true);
                dialog=builder.create();
                dialog.setCanceledOnTouchOutside(true);
                builder.show();
                break;
            case R.id.userinfo_rel_worship:
                break;
        }
    }

}
