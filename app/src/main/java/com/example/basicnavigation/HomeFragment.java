package com.example.basicnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

public class HomeFragment extends Fragment {

    private Fragment thisFragment=this;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO STEP 2 - Set an OnClickListener, using Navigation.createNavigateOnClickListener()
        Button navigateButton = (Button) view.findViewById(R.id.navigate_destination_button);
//        navigateButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.flow_step_one_dest,null));
        //TODO END STEP 2

        //TODO STEP 3 - Set NavOptions
        NavOptions.Builder navOptionsBuilder = new NavOptions.Builder();
        navOptionsBuilder.setEnterAnim(R.anim.slide_in_right);
        navOptionsBuilder.setExitAnim(R.anim.slide_out_left);
        navOptionsBuilder.setPopEnterAnim(R.anim.slide_in_left);
        navOptionsBuilder.setPopExitAnim(R.anim.slide_out_right);
        final NavOptions options = navOptionsBuilder.build();
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(thisFragment).navigate(R.id.flow_step_one_dest,null,options);
            }
        });
        //TODO END STEP 3

        //TODO STEP 4 - OnClickListener to navigate using an action
        //Button actionButton = (Button) view.findViewById(R.id.navigate_action_button);
        //actionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action,null));
        //TODO END STEP 4

        //TODO STEP 7 - Update the OnClickListener to navigate using an action and using  ...Direction clases for arguments
        Button actionButton = (Button) getView().findViewById(R.id.navigate_action_button);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flowStepNumber=1; //
                HomeFragmentDirections.NextAction action = HomeFragmentDirections.nextAction();
                action.setFlowStepNumber(flowStepNumber);
                NavHostFragment.findNavController(thisFragment).navigate(action);
            }
        });
        //TODO END STEP 7

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }
}
