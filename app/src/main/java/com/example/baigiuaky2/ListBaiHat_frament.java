package com.example.baigiuaky2;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class ListBaiHat_frament extends Fragment{
    List<baiHat> arrayBaiHat;
    baihatAdapter baohatadp;
    Button btnxoa;
    ListView listbaihat;
    int vitrixoa=-1 ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);

        Bundle bd = new Bundle();
        //anh xa
        btnxoa=(Button)view.findViewById(R.id.btnXoa);
        listbaihat =(ListView) view.findViewById(R.id.list_item);


        //su kien xoa
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vitrixoa ==-1){
                    Toast.makeText(view.getContext(), "Chưa chọn vị trí xóa!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    xacnhanxoa(vitrixoa);
                    vitrixoa =-1;
                }
            }
        });

        //su kien long click List bai hat
        listbaihat.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitrixoa = i;
                Toast.makeText(view.getContext(), "Nhấn xóa để xóa bài này", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //su kien click hien chi tiết bai hat
        listbaihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(view.getContext(),ChitietActivity.class);
                baiHat monan=  new baiHat();

                bd.putInt("anh",arrayBaiHat.get(i).getAnh());
                bd.putString("ten",arrayBaiHat.get(i).getTen());
                bd.putString("mota",arrayBaiHat.get(i).getMota());

                it.putExtra("dulieu",bd);
                startActivity(it);
            }
        });



        //them du lieu vao list
        arrayBaiHat = new ArrayList<>();
        arrayBaiHat.add(new baiHat(R.drawable.tnoaa,"There's no one at all","MT-P"));
        arrayBaiHat.add(new baiHat(R.drawable.ccyld,"Có chắc yêu là đây","MT-P"));
        arrayBaiHat.add(new baiHat(R.drawable.ctcht,"Chúng ta của hiện tại","MT-P"));
        arrayBaiHat.add(new baiHat(R.drawable.atbe,"Âm thầm bên em","MT-P"));
        arrayBaiHat.add(new baiHat(R.drawable.cmnq,"Cơn mưa ngang qua","MT-P"));
        arrayBaiHat.add(new baiHat(R.drawable.bdtnr,"Buông đôi tay nhau ra","MT-P"));
        arrayBaiHat.add(new baiHat(R.drawable.nnca,"Nơi này có anh","MT-P"));
        baohatadp = new baihatAdapter(getContext(),R.layout.dongbaihat,arrayBaiHat);
        listbaihat.setAdapter(baohatadp);

        return view;

    }

    //ham xac nhan xoa
    private void xacnhanxoa(int xoa){
        AlertDialog.Builder alerdialog = new AlertDialog.Builder(getContext());
        alerdialog.setTitle("THÔNG BÁO");
        alerdialog.setTitle("Bạn có muốn xóa bài "+arrayBaiHat.get(xoa).getTen());

        alerdialog.setPositiveButton("Xác nhận xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Đã xóa bài hát "+arrayBaiHat.get(xoa).getTen(), Toast.LENGTH_SHORT).show();
                arrayBaiHat.remove(xoa);
                baohatadp.notifyDataSetChanged();
            }
        });
        alerdialog.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alerdialog.setIcon(R.mipmap.ic_launcher);
        alerdialog.show();


    }

}


