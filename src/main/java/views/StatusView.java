package views;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Observable;

public class StatusView implements Observer<ViewModel> {
    @Override
    public void onSubscribe(Disposable disposable) {
    }

    @Override
    public void onNext(ViewModel viewModel) {

        System.out.print("\rCreated paperclips: ");
        System.out.print( "\r" + viewModel.getCreatedPaperclips());
        //System.out.print("\r" + viewModel.getUnsoldInventory());


    }

    @Override
    public void onError(Throwable throwable) {
    }

    @Override
    public void onComplete() {
    }


//    @Override
//    public void update(Observable o, Object arg) {
//       ViewModel view = (ViewModel) arg;
//        System.out.println("Observer triggered");
//        System.out.println(view.getClipsPersSecond());
//    }
}
