package com.sample.ui.activity.view;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.sample.R;
import com.siberiadante.lib.util.ScreenUtil;
import com.siberiadante.lib.util.ToastUtil;
import com.siberiadante.lib.view.EditDialog;
import com.siberiadante.lib.view.BottomPopupWindow;
import com.siberiadante.lib.view.EnsureDialog;
import com.siberiadante.lib.view.NiceDialog;
import com.siberiadante.lib.view.TitleBar;
import com.siberiadante.lib.view.nicedialog.BaseNiceDialog;
import com.siberiadante.lib.view.nicedialog.ViewConvertListener;
import com.siberiadante.lib.view.nicedialog.ViewHolder;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = DialogActivity.class.getSimpleName();
    private EnsureDialog ensureDialog;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ScreenUtil.setStatusTranslucent(this);
        initView();
        initData();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initView() {
        findViewById(R.id.btn_general_dialog_one).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_two).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_three).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_four).setOnClickListener(this);
        findViewById(R.id.btn_bottom_popup_widow).setOnClickListener(this);
        findViewById(R.id.btn_edit_dialog).setOnClickListener(this);
        findViewById(R.id.btn_share_dialog).setOnClickListener(this);
        findViewById(R.id.btn_friend_setting).setOnClickListener(this);
        findViewById(R.id.btn_comment_dialog).setOnClickListener(this);
        findViewById(R.id.btn_red_package_dialog).setOnClickListener(this);
        findViewById(R.id.btn_loading_dialog).setOnClickListener(this);
//        findViewById(R.id.btn_ensure_dialog_0).setOnClickListener(this);
//        findViewById(R.id.btn_ensure_dialog_1).setOnClickListener(this);
        TitleBar titleBar = ((TitleBar) findViewById(R.id.titleBar_dialog_activity));
        initTitle(titleBar);
    }

    private void initTitle(TitleBar titleBar) {
        titleBar.setImmersive(true);
        titleBar.setTitle("各种Dialog组件封装");
        titleBar.setSubTitle("SiberiaDante");
        titleBar.setSubTitleColor(getResources().getColor(R.color.gray));
        titleBar.setLeftImage(R.mipmap.back);
        titleBar.setLeftText("返回");
        titleBar.setRightImage(R.mipmap.search);
        titleBar.setDivideBackground(getResources().getColor(R.color.colorPrimary));
        titleBar.setTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showTextLong("点击了标题");
            }
        });
        titleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogActivity.this.finish();
            }
        });
        titleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.toast("点击了右侧");
            }
        });
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_general_dialog_one:
                showEnsureDialogOne();
                break;
            case R.id.btn_general_dialog_two:
                showEnsureDialogTwo();
                break;
            case R.id.btn_general_dialog_three:
                showEnsureDialogThree();
                break;
            case R.id.btn_general_dialog_four:
                showEnsureDialogFour();
                break;
            case R.id.btn_bottom_popup_widow:
                showBottomPopupWindow();
                break;
            case R.id.btn_edit_dialog:
                showEditDialog();
                break;
            case R.id.btn_share_dialog:
                showShareDialog();
                break;
            case R.id.btn_friend_setting:
                showFriendSettingDialog();
                break;
            case R.id.btn_comment_dialog:
                showCommentDialog();
                break;
            case R.id.btn_red_package_dialog:
                showRedPackageDialog();
                break;
            case R.id.btn_loading_dialog:
                showLoadingDialog();
                break;
//            case R.id.btn_ensure_dialog_0:
//                showEnsureNiceDialog0();
//                break;
//            case R.id.btn_ensure_dialog_1:
//                showEnsureNiceDialog1();
//                break;

        }
    }

    /**
     * EditDialog
     */
    private void showEditDialog() {
        final EditDialog dialog = new EditDialog(this).builder();
        dialog.setTitle("可编辑Dialog");
        dialog.setCancelable(false);
        dialog.setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        dialog.setPositiveButton("确定", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String msg = dialog.getMsg();
                ToastUtil.showTextLong("输入内容为：" + msg);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /**
     * BottomPopupWindow
     */
    private void showBottomPopupWindow() {
        new BottomPopupWindow(this).builder()
                .setTitle("选择").setCancelable(false).setCanceled(true)
                .addSheetItem("相机", BottomPopupWindow.SheetItemColor.Blue, new BottomPopupWindow.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        //需要对相机进行运行时权限的申请
                    }
                })
                .addSheetItem("相册", BottomPopupWindow.SheetItemColor.Blue, new BottomPopupWindow.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        //调用手机相册的方法,该方法在下面有具体实现
                    }
                }).show();
    }

    /**
     * EnsureDialog
     */
    private void showEnsureDialogOne() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.black))//可以不设置标题颜色，默认系统颜色
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.red), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogTwo() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.black))//可以不设置标题颜色，默认系统颜色
                .setSubTitle("这是一个副标题")
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.red), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogThree() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.black))//可以不设置标题颜色，默认系统颜色
                .setIncon(R.mipmap.tip_icon)//不设置图标，默认没有图标
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.red), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogFour() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", R.color.black)//可以不设置标题颜色，默认系统颜色
                .setCancelable(false)
                .setCenterButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
        ;
        ensureDialog.show();
    }

    /**
     * share dialog
     */
    private void showShareDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.share_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtil.toast("分享成功");
                            }
                        });
                    }
                })
                .setDimAmount(0.3f)
                .setShowBottom(true)
                .show(getSupportFragmentManager());
    }

    /**
     * friend setting dialog
     */
    private void showFriendSettingDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.friend_set_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                    }
                })
                .setShowBottom(true)
                .setHeight(310)
                .show(getSupportFragmentManager());
    }

    /**
     * comment dialog
     */
    private void showCommentDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.comment_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        final EditText editText = holder.getView(R.id.edit_input);
                        editText.post(new Runnable() {
                            @Override
                            public void run() {
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.showSoftInput(editText, 0);
                            }
                        });
                    }
                })
                .setShowBottom(true)
                .show(getSupportFragmentManager());
    }

    /**
     * red package dialog
     */
    private void showRedPackageDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.ad_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setWidth(210)
                .setOutCancel(false)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }

    /**
     * loading dialog
     */
    private void showLoadingDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.loading_layout)
                .setWidth(100)
                .setHeight(100)
                .setDimAmount(0)
                .show(getSupportFragmentManager());
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Dialog Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}