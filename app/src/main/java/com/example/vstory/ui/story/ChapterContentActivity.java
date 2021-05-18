package com.example.vstory.ui.story;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vstory.R;
import com.example.vstory.apiservice.Service;
import com.example.vstory.model.Chapter;

import java.util.List;

public class ChapterContentActivity<chapterContentFragment> extends AppCompatActivity {

    private Button btn_previous, btn_next;
    private List<Chapter> listChapter;

    private int currentChap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_content);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        btn_next = findViewById(R.id.btn_next);
        btn_previous = findViewById(R.id.btn_previous);

//        listChapter = new ArrayList<>();
//        listChapter.add(new Chapter(1, 1, "Chung ta lam gi?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\n" +
//                "\n"));
//        listChapter.add(new Chapter(2, 2, "Chung ta lam gi?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\n" +
//                "\n"));
//        listChapter.add(new Chapter(3, 3, "Chung ta lam gi?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\n" +
//                "\n"));
//        listChapter.add(new Chapter(4, 4, "Chung ta lam gi?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nec dui nunc mattis enim ut tellus elementum. A diam sollicitudin tempor id eu nisl nunc. Dignissim convallis aenean et tortor at risus viverra. Pellentesque dignissim enim sit amet venenatis urna cursus. Mi sit amet mauris commodo. Mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Libero justo laoreet sit amet. Cursus euismod quis viverra nibh cras pulvinar mattis nunc. Enim sed faucibus turpis in eu mi bibendum neque egestas. Eleifend donec pretium vulputate sapien. Quis hendrerit dolor magna eget est lorem ipsum dolor. At consectetur lorem donec massa sapien faucibus et molestie ac. Scelerisque purus semper eget duis at tellus at urna condimentum. Odio tempor orci dapibus ultrices in iaculis nunc sed. A arcu cursus vitae congue mauris rhoncus aenean vel. Arcu dui vivamus arcu felis bibendum ut tristique. Urna cursus eget nunc scelerisque viverra mauris. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu.\n" +
//                "\n"));

        Intent intent = getIntent();
        int idStory = intent.getIntExtra(AboutStoryActivity.ID_STORY, 0);

        Service service = new Service(this);
        service.getChapterByStory(idStory, new Service.GetListChapterResponse() {
            @Override
            public void onError(String message) {
                Toast.makeText(ChapterContentActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<Chapter> listChap) {
                listChapter = listChap;
                currentChap = 0;
                addMainFrag();
            }
        });





        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v.equals(btn_previous)) {
                    if(!btn_next.isActivated()){
                        btn_next.setVisibility(View.VISIBLE);
                    }
                    if(currentChap > 0){
                        currentChap--;
                        replaceChapterContentFrag(currentChap);
                        if(currentChap == 0){
                            btn_previous.setVisibility(View.GONE);
                        }
                        return;
                    }
                }

                if(v.equals(btn_next)) {
                    if(!btn_previous.isActivated()){
                        btn_previous.setVisibility(View.VISIBLE);
                    }
                    if(currentChap < listChapter.size() - 1) {
                        currentChap++;
                        replaceChapterContentFrag(currentChap);
                        if(currentChap == listChapter.size() - 1){
                            btn_next.setVisibility(View.GONE);
                        }
                        return;
                    }
                }
            }
        };

        btn_previous.setOnClickListener(listener);
        btn_next.setOnClickListener(listener);



    }


    private void addMainFrag(){
        FragmentManager manager = this.getSupportFragmentManager();
        ChapterContentFragment chapterContentFragment = new ChapterContentFragment();
        chapterContentFragment.setData(listChapter.get(currentChap));
        manager.beginTransaction()
                .add(R.id.frame_layout_chapter, chapterContentFragment, chapterContentFragment.getTag())
                .commit();
    }

    private void replaceChapterContentFrag(int idChapter){
        FragmentManager manager = this.getSupportFragmentManager();
        ChapterContentFragment chapterContentFragment = new ChapterContentFragment();
        chapterContentFragment.setData(listChapter.get(idChapter));
        manager.beginTransaction()
                .replace(R.id.frame_layout_chapter, chapterContentFragment, chapterContentFragment.getTag())
                .commit();
    }


}