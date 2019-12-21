package com.example.patcoffeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PatCoffListActivity extends AppCompatActivity {

    List<String> foodsList;
    List<String> foodsNames;
    List<String> drinksList;
    List<String> drinksNames;
    List<String> snacksList;
    List<String> snacksNames;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_coff_list);

        foodsList = new ArrayList<String>();
        drinksList = new ArrayList<String>();
        snacksList = new ArrayList<String>();
        foodsNames = new ArrayList<String>();
        drinksNames = new ArrayList<String>();
        snacksNames = new ArrayList<String>();

        recyclerView = findViewById(R.id.recyclerview);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(PatCoffeeMain2Activity.EXTRA_MESSAGE);

        if(message.equals("1")){
            loadFoodList();
        }else if(message.equals("2")){
            loadDrinksList();
        }else if(message.equals("3")){
            loadSnacksList();
        }

        final Intent intentClick = new Intent(this, MainActivity.class);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well
                Toast.makeText(PatCoffListActivity.this, "Single Click on position        :"+position,
                        Toast.LENGTH_SHORT).show();
                startActivity(intentClick);

            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(PatCoffListActivity.this, "Long press on position :"+position,
                        Toast.LENGTH_LONG).show();
            }
        }));

    }

    private void loadFoodList(){

        foodsList.add("https://one_org_international.s3.amazonaws.com/africa/wp-content/uploads/2014/11/Screen-Shot-2014-11-25-at-15.05.41.png");
        foodsNames.add("Vegetable Soup");

        foodsList.add("https://guardian.ng/wp-content/uploads/2017/10/1-Lagxx.jpg");
        foodsNames.add("Tomato Salad");

        foodsList.add("https://cdn.face2faceafrica.com/www/wp-content/uploads/2018/03/feat.jpg");
        foodsNames.add("Crayfish Bamda Dish");

        foodsList.add("https://www.lowcarbafrica.com/wp-content/uploads/2019/08/Efo-Riro-Nigerian-Spinach-Stew-pinterest.jpg");
        foodsNames.add("Spinach Stew");

        foodsList.add("https://answersafrica.com/wp-content/uploads/2013/04/fried-rice-1-640x387.jpg");
        foodsNames.add("African Rice");

        initRecyclerView();

    }

    private void loadDrinksList(){

        drinksList.add("https://images.pexels.com/photos/338713/pexels-photo-338713.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500.jpg");
        drinksNames.add("Orange Juice");

        drinksList.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/classic-drinks-1556896392.jpg");
        drinksNames.add("Classic Cocktails");

        drinksList.add("https://p2d7x8x2.stackpathcdn.com/wordpress/wp-content/uploads/2017/07/round-of-drinks-640x427.jpg");
        drinksNames.add("Coffee Drink");

        drinksList.add("https://www-konga-com-res.cloudinary.com/image/upload/v1549423388/landingPages/drinks/drinks_5_hen.jpg");
        drinksNames.add("Henekein");

        drinksList.add("https://i.ytimg.com/vi/Tr8QdEDXhhM/maxresdefault.jpg");
        drinksNames.add("Holiday Drink");

        initRecyclerView();

    }

    private void loadSnacksList(){

        snacksList.add("https://image.shutterstock.com/image-photo/salty-snacks-pretzels-chips-crackers-600w-637166818.jpg");
        snacksNames.add("Crackers");

        snacksList.add("https://image.shutterstock.com/image-photo/savory-party-snack-selection-white-600w-185699627.jpg");
        snacksNames.add("Cheese");

        snacksList.add("https://image.shutterstock.com/image-illustration/cracked-chocolate-bar-caramel-crispy-600w-1192417084.jpg");
        snacksNames.add("Chocolate");

        snacksList.add("https://image.shutterstock.com/image-photo/pub-menu-snack-enjoy-your-260nw-1408723310.jpg");
        snacksNames.add("French Fries Fish Snacks");

        snacksList.add("https://image.shutterstock.com/image-photo/coriander-kothimbir-vada-samosa-kachori-600w-351721442.jpg");
        snacksNames.add("Samosa Indian Snacks and Tea");

        initRecyclerView();

    }

    private void initRecyclerView(){

        PatCoffAdapter patCoffAdapter = new PatCoffAdapter(this, foodsList, foodsNames, drinksList, drinksNames,
                snacksList, snacksNames);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(patCoffAdapter);
        recyclerView.setLayoutManager(layoutManager);
        patCoffAdapter.notifyDataSetChanged();


    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
