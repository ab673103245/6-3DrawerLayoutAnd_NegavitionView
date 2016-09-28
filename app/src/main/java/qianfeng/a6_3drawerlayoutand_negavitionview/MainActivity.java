package qianfeng.a6_3drawerlayoutand_negavitionview;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigation_view;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = ((DrawerLayout) findViewById(R.id.drwaerLayout));
        navigation_view = ((NavigationView) findViewById(R.id.design_navigation_view));
        toolBar = ((Toolbar) findViewById(R.id.toolBar));
        setSupportActionBar(toolBar);

        // navigationView里面有一个点击菜单布局的监听方法 navigationView里面有个可以监听到菜单点击的方法
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.send: {
                        Toast.makeText(MainActivity.this,"发送",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.LEFT);
                    }
                        break;

                    case R.id.moments:
                        Toast.makeText(MainActivity.this,"朋友圈",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                }
                return true;
            }
        });

        //nagavitionView:里面设置图片的色彩模式，只能通过java代码设置彩色,在布局文件里面只能统一设置一种颜色（menu的Icon的颜色）
        navigation_view.setItemIconTintList(null); // 给null就是还原图片原来的颜色

        // toggle将drawerLayout和toolbar关联起来。
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, 0, 0);
        // 在drawerLayout的点击事件里面，将toggle关联起来
        drawerLayout.setDrawerListener(toggle);
        // 同步ActionBar和drawerLayout的状态
        toggle.syncState();





    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(Gravity.LEFT))
        {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }else
        {
            super.onBackPressed();
        }
    }
}
