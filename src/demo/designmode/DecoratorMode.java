package demo.designmode;

// 定义一个接口，表示通知器的基本功能
interface Notifier {
    void send(String message);
}

// 定义一个具体的通知器，它实现了基本的邮件通知功能
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

// 定义一个装饰器类，它包装了一个通知器，并提供了与通知器相同的接口
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// 定义一个具体的装饰器，它添加了一个新的功能：手机短信通知
class SmsNotifier extends NotifierDecorator {
    public SmsNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS notification: " + message);
    }
}

// 定义一个具体的装饰器，它添加了一个新的功能：微信通知
class WeChatNotifier extends NotifierDecorator {
    public WeChatNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending WeChat notification: " + message);
    }
}

// 使用装饰器模式
public class DecoratorMode {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new SmsNotifier(notifier);
        notifier = new WeChatNotifier(notifier);

        notifier.send("Hello, world!");
    }
}
