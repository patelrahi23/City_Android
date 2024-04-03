package com.rahi.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.rahi.cityguide.Common.LoginSignUp.RetailerSignUpScreen;
import com.rahi.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.rahi.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.rahi.cityguide.HelperClasses.HomeAdapter.MVAdapter;
import com.rahi.cityguide.HelperClasses.HomeAdapter.MVHelperClass;
import com.rahi.cityguide.HelperClasses.HomeAdapter.categoriesAdapter;
import com.rahi.cityguide.HelperClasses.HomeAdapter.categoriesHelperClass;
import com.rahi.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView featuredRecycler,mostViewedRecycler,categoriesRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuImg,add_user;
    static final float END_SCALE=0.7f;
    LinearLayout contentView;
    //DrawerLayout
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);
        featuredRecycler=findViewById(R.id.featured_recycler);
        mostViewedRecycler=findViewById(R.id.mostViewedRecycler);
        categoriesRecycler = findViewById(R.id.categoriesRecycler);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuImg = findViewById(R.id.menuImg);
        add_user=findViewById(R.id.add_user);
        contentView = findViewById(R.id.contentView);


        navigationDrawer();
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                final float diffScaledOffSet = slideOffset*(1-END_SCALE);
                final float offsetScale = 1-diffScaledOffSet;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth()*slideOffset;
                final float xOffsetDiff = contentView.getWidth()*diffScaledOffSet/2;
                final float xTranslation = xOffset-xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_all_categories:
                Intent intent = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intent);
                break;

            case R.id.nav_login:
                Intent intent1 = new Intent(getApplicationContext(),RetailerSignUpScreen.class);
                startActivity(intent1);
                break;
        }

        return true;
    }

    private void featuredRecycler(){
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        ArrayList<FeaturedHelperClass> featuredlocations = new ArrayList<>();
        featuredlocations.add(new FeaturedHelperClass(R.drawable.mcdonalds,"McDonald's","mnasbdas ajsdkas ajsdba absdj iasjd a siaj aisjd a a a aikjnas dai sjf nsd"));
        featuredlocations.add(new FeaturedHelperClass(R.drawable.city_1,"Edenrobe","mnasbdas ajsdkas ajsdba absdj iasjd a siaj aisjd a a a aikjnas dai sjf nsd"));
        featuredlocations.add(new FeaturedHelperClass(R.drawable.city_2,"sweet and Bakers","mnasbdas ajsdkas ajsdba absdj iasjd a siaj aisjd a a a aikjnas dai sjf nsd"));
        adapter = new FeaturedAdapter(featuredlocations);
        featuredRecycler.setAdapter(adapter);
    }
    private void mostViewedRecycler(){
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        ArrayList<MVHelperClass> mvlocations = new ArrayList<>();
        mvlocations.add(new MVHelperClass(R.drawable.mcdonalds,"McDonald's","mnasbdas ajsdkas ajsdba absdj iasjd a siaj aisjd a a a aikjnas dai sjf nsd"));
        mvlocations.add(new MVHelperClass(R.drawable.city_1,"Edenrobe","mnasbdas ajsdkas ajsdba absdj iasjd a siaj aisjd a a a aikjnas dai sjf nsd"));
        mvlocations.add(new MVHelperClass(R.drawable.city_2,"sweet and Bakers","mnasbdas ajsdkas ajsdba absdj iasjd a siaj aisjd a a a aikjnas dai sjf nsd"));
        adapter = new MVAdapter(mvlocations);
        mostViewedRecycler.setAdapter(adapter);
    }
    private void categoriesRecycler(){
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        ArrayList<categoriesHelperClass> categorieslocation = new ArrayList<>();
        categorieslocation.add(new categoriesHelperClass(R.drawable.mcdonalds,"McDonald's"));
        categorieslocation.add(new categoriesHelperClass(R.drawable.city_1,"Edenrobe"));
        categorieslocation.add(new categoriesHelperClass(R.drawable.city_2,"sweet and bakers"));

        adapter = new categoriesAdapter(categorieslocation);
        categoriesRecycler.setAdapter(adapter);

    }

    public void callRetailerScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), RetailerSignUpScreen.class);
        startActivity(intent);
    }
}