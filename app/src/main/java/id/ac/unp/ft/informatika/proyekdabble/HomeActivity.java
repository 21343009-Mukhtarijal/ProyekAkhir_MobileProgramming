package id.ac.unp.ft.informatika.proyekdabble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView titleTextView;
    private RecyclerView communityRecyclerView;
    private Button addCommunityButton; // Ganti nama tombol menjadi "addCommunityButton"

    private List<Community> communityList;

    private CommunityAdapter communityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inisialisasi komponen UI
        titleTextView = findViewById(R.id.titleTextView);
        communityRecyclerView = findViewById(R.id.communityRecyclerView);
        addCommunityButton = findViewById(R.id.addCommunityButton); // Ganti ID tombol menjadi "addCommunityButton"

        // Inisialisasi daftar komunitas (dummy data)
        communityList = createDummyCommunities(); // Tambahkan beberapa komunitas dummy

        // Inisialisasi adapter dan atur untuk RecyclerView
        communityAdapter = new CommunityAdapter(communityList);
        communityRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        communityRecyclerView.setAdapter(communityAdapter);

        // Set listener untuk menangani klik pada item komunitas
        communityAdapter.setOnItemClickListener(new CommunityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle navigasi ke halaman komunitas sesuai dengan posisi item yang diklik
                Community selectedCommunity = communityList.get(position);
                navigateToCommunity(selectedCommunity);
            }
        });

        // Set listener untuk menangani klik tombol "Tambah Komunitas"
        addCommunityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAddCommunity();
            }
        });
    }

    // Metode untuk membuat data komunitas dummy
    private List<Community> createDummyCommunities() {
        List<Community> dummyCommunities = new ArrayList<>();
        dummyCommunities.add(new Community(1, "Pemrograman"));
        dummyCommunities.add(new Community(2, "Fotografi"));
        dummyCommunities.add(new Community(3, "Desain Grafis"));
        // Tambahkan komunitas lainnya sesuai kebutuhan
        return dummyCommunities;
    }

    // Metode untuk menangani navigasi ke halaman komunitas
    private void navigateToCommunity(Community selectedCommunity) {
        Intent intent = new Intent(this, CommunityActivity.class);
        intent.putExtra("community_id", selectedCommunity.getId());
        startActivity(intent);
    }

    // Metode untuk menangani navigasi ke halaman tambah komunitas
    private void navigateToAddCommunity() {
        Intent intent = new Intent(this, AddCommunityActivity.class);
        startActivity(intent);
    }
}