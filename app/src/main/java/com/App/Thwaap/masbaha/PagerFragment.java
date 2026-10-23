package com.App.Thwaap.masbaha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.App.Thwaap.R;
import com.App.Thwaap.databinding.ItemMasbahaBinding;

public class PagerFragment extends Fragment {
    private static final String ARG_POSITION = "arg_position";
    private static final String ARG_LAYOUT = "arg_layout";

    private ItemMasbahaBinding binding;
    private int position;
    private int layout;

    public PagerFragment() {
        // Required empty public constructor
    }

    public static PagerFragment newInstance(int position, int layout) {
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        args.putInt(ARG_LAYOUT, layout);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION, 0);
            layout = getArguments().getInt(ARG_LAYOUT, 1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ItemMasbahaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switch (layout) {
            case 1:
                binding.colordFrame.setBackgroundResource(R.drawable.bk_round_item);
                break;
            case 2:
                binding.colordFrame.setBackgroundResource(R.drawable.bk_round_item2);
                break;
            case 3:
                binding.colordFrame.setBackgroundResource(R.drawable.bk_round_item3);
                break;
            case 4:
                binding.colordFrame.setBackgroundResource(R.drawable.bk_round_item4);
                break;
            case 5:
                binding.colordFrame.setBackgroundResource(R.drawable.bk_round_item5);
                break;
            default:
                binding.colordFrame.setBackgroundResource(R.drawable.bk_round_item);
                break;
        }

        binding.counter.setText(String.valueOf(position + 1));
        binding.colordFrame.invalidate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
