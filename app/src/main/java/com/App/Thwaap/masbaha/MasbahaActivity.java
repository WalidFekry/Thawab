package com.App.Thwaap.masbaha;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityMasbahaBinding;
import com.App.Thwaap.utils.PreferencesManager;

public class MasbahaActivity extends BaseActivity {

    private ActivityMasbahaBinding binding;
    private PreferencesManager preferencesManager;
    private int selection = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMasbahaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferencesManager = new PreferencesManager(this);

        binding.recyclerMasbaha.setEnabled(false);

        binding.ivReset.setOnClickListener(v -> {
            preferencesManager.clearMasbahaIndex(selection);
            setAdapter(selection);
        });

        binding.iv1.setOnClickListener(v -> selectIndex(1));
        binding.iv2.setOnClickListener(v -> selectIndex(2));
        binding.iv3.setOnClickListener(v -> selectIndex(3));
        binding.iv4.setOnClickListener(v -> selectIndex(4));
        binding.iv5.setOnClickListener(v -> selectIndex(5));

        setAdapter(1);

        binding.view.setOnClickListener(v -> {
            int currentItem = binding.recyclerMasbaha.getCurrentItem();
            int maxCount = (selection == 5) ? 999 : 99;

            if (currentItem < maxCount) {
                binding.recyclerMasbaha.setCurrentItem(currentItem + 1, true);
            } else {
                binding.recyclerMasbaha.setCurrentItem(0, true);
            }
            preferencesManager.setMasbahaIndex(selection, binding.recyclerMasbaha.getCurrentItem());
        });
    }

    private void selectIndex(int index) {
        selection = index;
        setAdapter(index);
    }

    @SuppressWarnings("deprecation")
    private void setAdapter(final int i) {
        binding.recyclerMasbaha.setAdapter(null);
        binding.recyclerMasbaha.invalidate();

        binding.recyclerMasbaha.setAdapter(new FragmentStatePagerAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return PagerFragment.newInstance(position, i);
            }

            @Override
            public int getCount() {
                return (i == 5) ? 1000 : 100;
            }
        });

        binding.recyclerMasbaha.setCurrentItem(preferencesManager.getMasbahaIndex(i), false);
        binding.recyclerMasbaha.setOffscreenPageLimit(0);
        binding.recyclerMasbaha.invalidate();

        switch (i) {
            case 1:
                binding.tvTitle.setText("لا إله إلا الله");
                binding.tvDesc.setText("فضلها : عن النبي صلى الله عليه وسلم أنه قال : من قال لا إله إلا الله صدقًا من قلبه دخل الجنة");
                break;
            case 2:
                binding.tvTitle.setText("أستغفر الله العظيم وأتوب إليه");
                binding.tvDesc.setText("فضلها : قال رسول الله ﷺ: يا أيها الناس توبوا إلى الله، فإني أتوب في اليوم إليه مائة مرة.");
                break;
            case 3:
                binding.tvTitle.setText("سُبْحَانَ اللهِ، وَالْحْمدُ لِلهِ، وَلَا إِلهَ إِلَّا اللهُ، وَاللهُ أَكْبَرُ");
                binding.tvDesc.setText("فضلها : قال رسول الله صلى الله عليه وسلم : سُبْحَانَ اللهِ، وَالْحْمدُ لِلهِ، وَلَا إِلهَ إِلَّا اللهُ، وَاللهُ أَكْبَرُ؛ تُغْرَسُ لَكَ بِكُلِّ وَاحِدَةٍ شَجَرَةٌ فِي الْجَنَّةِ");
                break;
            case 4:
                binding.tvTitle.setText("اللهم صلِّ على سيدنا محمد ");
                binding.tvDesc.setText("فضلها : قال رسول الله صلى الله عليه وسلم : (من صلى عليَّ حين يصبح عشرًا ، وحين يمسي عشرًا ، أدركته شفاعتي يوم القيامة)");
                break;
            case 5:
                binding.tvTitle.setText("سبحان الله وبحمده");
                binding.tvDesc.setText("فضلها : قال رسول الله صلى الله عليه وسلم (مَنْ قَالَ سُبْحَانَ اللَّهِ وَبِحَمْدِهِ فِي يَوْمٍ مِائَةَ مَرَّةٍ حُطَّتْ خَطَايَاهُ وَإِنْ كَانَتْ مِثْلَ زَبَدِ الْبَحْرِ)");
                break;
            default:
                break;
        }
    }

    public void onBackClicked(View view) {
        onBackPressed();
    }
}
