package com.kaceykaso.bestbox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by kcoughli on 3/6/15.
 */
public class BestBoxFragment extends Fragment {

    private BestBox mBestBox;

    public static BestBoxFragment newInstance() {
        return new BestBoxFragment();
    }

    // Verify lists working
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retain fragment during activity lifecycle
        setRetainInstance(true);
        mBestBox = new BestBox(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_best_box, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.fragment_best_box_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        // Pass sounds into adapter
        recyclerView.setAdapter(new SoundAdapter(mBestBox.getSounds()));

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBestBox.release();
    }

    private class SoundHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Button mButton;
        private Sound mSound;

        // Create Holder for sounds
        public SoundHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.list_item_sound, container, false));

            // Make button
            mButton = (Button)itemView.findViewById(R.id.list_item_sound_button);
            // Listen for things
            mButton.setOnClickListener(this);
        }

        // Bind dem sounds
        public void bindSound(Sound sound) {
            mSound = sound;
            mButton.setText(mSound.getName());
        }

        @Override
        public void onClick(View v) {
            mBestBox.play(mSound);
        }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

        private List<Sound> mSounds;

        // Wire up list to adapter
        public SoundAdapter(List<Sound> sounds) {
            mSounds = sounds;
        }

        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new SoundHolder(inflater, parent);
        }

        // Hook up sounds
        @Override
        public void onBindViewHolder(SoundHolder soundHolder, int position) {
            Sound sound = mSounds.get(position);
            soundHolder.bindSound(sound);
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }
}
