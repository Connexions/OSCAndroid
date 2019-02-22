/**
 * Copyright (c) 2013 Rice University
 * 
 * This software is subject to the provisions of the GNU Lesser General
 * Public License Version 2.1 (LGPL).  See LICENSE.txt for details. 
 */
package org.openstaxcollege.android.activity;

import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentTransaction;
import android.view.*;
import org.openstaxcollege.android.R;
import org.openstaxcollege.android.beans.Content;
import org.openstaxcollege.android.fragment.SelectBookFragment;

import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;

/**
 * Activity to view list of OSC books available. 
 * 
 * @author Ed Woodward
 *
 */
public class SelectBookActivity extends AppCompatActivity
{
   
    /** list of books as Content objects */
    ArrayList<Content> content;
    
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectbook);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.select_book));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        SelectBookFragment fragment = new SelectBookFragment();
        transaction.replace(R.id.sample_content_fragment, fragment);
        transaction.commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            Intent mainIntent = new Intent(getApplicationContext(), BookshelfActivity.class);
            startActivity(mainIntent);
        }
        return true;

    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        //Log.d("ViewLenses.onSaveInstanceState()", "saving data");
        outState.putSerializable(getString(R.string.cache_lenstypes), content);
        
    }
    
}
