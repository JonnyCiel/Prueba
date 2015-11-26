package com.gedesoft.co.pronto.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gedesoft.co.pronto.R;
import com.gedesoft.co.pronto.drawingapp.DrawingActivity;
import com.gedesoft.co.pronto.movieapp.MovieActivity;
import com.gedesoft.co.pronto.reminderapp.ReminderActivity;
import com.gedesoft.co.pronto.todoapp.TodoActivity;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

public class NotepadActivity extends AppCompatActivity {

    private Drawer mDrawer=null;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Nav Drawer Header
        AccountHeader headResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .build();

        //Drawer build and pass account header
        mDrawer = new DrawerBuilder()
                .withAccountHeader(headResult)
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.label_notepad).withIcon(FontAwesome.Icon.faw_edit).withIdentifier(Constants.NOTEPAD),
                        new PrimaryDrawerItem().withName(R.string.label_todo).withIcon(FontAwesome.Icon.faw_list).withIdentifier(Constants.TODO),
                        new PrimaryDrawerItem().withName(R.string.label_drawing).withIcon(FontAwesome.Icon.faw_pencil).withIdentifier(Constants.DRAWING),
                        new PrimaryDrawerItem().withName(R.string.label_reminder).withIcon(FontAwesome.Icon.faw_clock_o).withIdentifier(Constants.REMINDER),
                        new PrimaryDrawerItem().withName(R.string.label_movies).withIcon(FontAwesome.Icon.faw_file_movie_o).withIdentifier(Constants.MOVIE),
                        new PrimaryDrawerItem().withName(R.string.label_settings).withIcon(FontAwesome.Icon.faw_cog).withIdentifier(Constants.SETTINGS)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null && drawerItem instanceof Nameable) {
                            String name = ((Nameable) drawerItem).getName().getText(NotepadActivity.this);
                            mToolbar.setTitle(name);

                            if (drawerItem != null) {

                                int IdItemClicked = drawerItem.getIdentifier();
                               onTouchDrawer(IdItemClicked);
                            }
                        }

                        return true;
                    }
                })
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {

                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {

                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                    }
                })
                .withFireOnInitialOnClick(true)
                .withSavedInstance(savedInstanceState)
                .build();

        onTouchDrawer(Constants.NOTEPAD);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onTouchDrawer(int id){

        switch (id){
            case Constants.NOTEPAD:
                //to be implemented
                break;
            case Constants.DRAWING:
                startActivity(new Intent(this, DrawingActivity.class));
                break;
            case Constants.MOVIE:
                startActivity(new Intent(this, MovieActivity.class));
                break;
            case Constants.REMINDER:
                startActivity(new Intent(this, ReminderActivity.class));
                break;
            case Constants.TODO:
                startActivity(new Intent(this, TodoActivity.class));
                break;
            case Constants.SETTINGS:
                //go to settings
        }
    }
}
