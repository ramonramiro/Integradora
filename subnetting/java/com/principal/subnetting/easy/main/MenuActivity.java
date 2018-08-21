package com.principal.subnetting.easy.main;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.principal.subnetting.easy.login.ForoActivity;
import com.principal.subnetting.easy.AditionalsFragment;
import com.principal.subnetting.easy.fragments.CalculatorFragment;
import com.principal.subnetting.easy.fragments.ClassExampleFragment;
import com.principal.subnetting.easy.fragments.CreditsFragment;
import com.principal.subnetting.easy.fragments.GuessFragment;
import com.principal.subnetting.easy.fragments.SocialNetworksFragment;
import com.principal.subnetting.easy.fragments.MemoryFragment;
import com.principal.subnetting.easy.fragments.QuizFragment;
import com.principal.subnetting.easy.fragments.TheoryFragment;
import com.principal.subnetting.easy.fragments.VideoFragment;
import com.principal.subnetting.easy.fragments.PublicPrivateFragment;
import com.principal.subnetting.easy.R;
import com.principal.subnetting.easy.fragments.TableFragment;
import com.principal.subnetting.easy.units.UnitFive;
import com.principal.subnetting.easy.units.UnitFour;
import com.principal.subnetting.easy.units.UnitOne;
import com.principal.subnetting.easy.units.UnitThree;
import com.principal.subnetting.easy.units.UnitTwo;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TheoryFragment.OnFragmentInteractionListener,
        VideoFragment.OnFragmentInteractionListener, CalculatorFragment.OnFragmentInteractionListener,
        MemoryFragment.OnFragmentInteractionListener, CreditsFragment.OnFragmentInteractionListener,
        QuizFragment.OnFragmentInteractionListener, GuessFragment.OnFragmentInteractionListener,
        SocialNetworksFragment.OnFragmentInteractionListener, TableFragment.OnFragmentInteractionListener,
        PublicPrivateFragment.OnFragmentInteractionListener, ClassExampleFragment.OnFragmentInteractionListener,
        AditionalsFragment.OnFragmentInteractionListener{




    String arrayName[];

    private CircleMenu circleMenu;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String arrayName[] = new String[] {getString(R.string.unit_one_message),
                getString(R.string.unit_two_message),
                getString(R.string.unit_three_message),
                getString(R.string.unit_four_message),
                getString(R.string.unit_five_message)};

        circleMenu = findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor(getString(R.string.color_green)), R.mipmap.icon_menu, R.mipmap.icon_cancel)
                .addSubMenu(Color.parseColor(getString(R.string.color_whit)), R.drawable.ic_unidad_uno)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        if (index == 0) {
                            Toast.makeText(MenuActivity.this, R.string.unit_one, Toast.LENGTH_SHORT).show();
                            Intent newFor = new Intent(MenuActivity.this, UnitOne.class);
                            startActivity(newFor);
                        } else {
                            if (index == 1) {
                                Toast.makeText(MenuActivity.this, R.string.unit_two, Toast.LENGTH_SHORT).show();
                                Intent newFor = new Intent(MenuActivity.this, UnitTwo.class);
                                startActivity(newFor);
                            } else {

                                if (index == 2) {
                                    Toast.makeText(MenuActivity.this, R.string.unit_three, Toast.LENGTH_SHORT).show();
                                    Intent newFor = new Intent(MenuActivity.this, UnitThree.class);
                                    //Esta es la actividad 3 ActivityThreeActivity
                                    startActivity(newFor);

                                }else {

                                    if (index == 3) {
                                        Toast.makeText(MenuActivity.this, R.string.unit_four, Toast.LENGTH_SHORT).show();
                                        Intent newFor = new Intent(MenuActivity.this, UnitFour.class);
                                        //Esta es la actividad 4 StepFourActivity
                                        startActivity(newFor);

                                    }else {
                                        if (index == 4) {
                                            Toast.makeText(MenuActivity.this, R.string.unit_five, Toast.LENGTH_SHORT).show();
                                            Intent newFor = new Intent(MenuActivity.this, UnitFive.class);
                                            startActivity(newFor);

                                        }
                                    }

                                }
                            }

                        }

                    }
                })
                .addSubMenu(Color.parseColor(getString(R.string.color_whit)), R.drawable.ic_unidad_dos)
                .addSubMenu(Color.parseColor(getString(R.string.color_whit)), R.drawable.ic_unidad_tres)
                .addSubMenu(Color.parseColor(getString(R.string.color_whit)), R.drawable.ic_unidad_cuatro)
                .addSubMenu(Color.parseColor(getString(R.string.color_whit)),R.drawable.ic_unidad_cinco);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.foros, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MenuActivity.this, ForoActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
      /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    public void goHome(){
        finish();
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
    }

    public void other(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean selectedFrgament = false;

        if (id == R.id.nav_home) {

            if(fragment!=null){
               // Log.i("Fragment: ", fragment.toString());
                other(fragment);
            }

        } else if (id == R.id.nav_calculator) {
            fragment = new CalculatorFragment();
            selectedFrgament =true;


        } else if (id == R.id.nav_videos) {
            fragment = new VideoFragment();
            selectedFrgament =true;

        } else if (id == R.id.nav_quiz) {
            fragment = new QuizFragment();
            selectedFrgament =true;

        } else if (id == R.id.nav_credits) {
            fragment = new CreditsFragment();
            selectedFrgament =true;


        } else if (id == R.id.nav_memory) {
            fragment = new MemoryFragment();
            selectedFrgament =true;

        } else if (id == R.id.nav_guess) {
            fragment = new GuessFragment();
            selectedFrgament =true;


        } else if (id == R.id.nav_foros) {
            fragment = new SocialNetworksFragment();
            selectedFrgament =true;

        } else if (id == R.id.nav_table) {
            fragment = new TableFragment();
            selectedFrgament =true;

        }else if (id == R.id.nav_public) {
            fragment = new PublicPrivateFragment();
            selectedFrgament =true;

        }else if (id == R.id.nav_example) {
            fragment = new ClassExampleFragment();
            selectedFrgament =true;

        }else if (id == R.id.nav_aditionals) {
            fragment = new AditionalsFragment();
            selectedFrgament =true;

        } else if (id == R.id.nav_exit) {
            finish();

        }

        if (selectedFrgament){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
            // getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment, "fragment_tag").addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
