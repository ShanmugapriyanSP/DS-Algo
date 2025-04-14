package com.data.structures.algorithms.java.design.patterns;

import com.data.structures.algorithms.java.design.patterns.behavioral.chainofresponsibility.Currency;
import com.data.structures.algorithms.java.design.patterns.behavioral.chainofresponsibility.FiftyDollarDispenser;
import com.data.structures.algorithms.java.design.patterns.behavioral.chainofresponsibility.TenDollarDispenser;
import com.data.structures.algorithms.java.design.patterns.behavioral.chainofresponsibility.TwentyDollarDispenser;
import com.data.structures.algorithms.java.design.patterns.behavioral.command.*;
import com.data.structures.algorithms.java.design.patterns.behavioral.iterator.Channel;
import com.data.structures.algorithms.java.design.patterns.behavioral.iterator.ChannelCollectionImpl;
import com.data.structures.algorithms.java.design.patterns.behavioral.iterator.ChannelIterator;
import com.data.structures.algorithms.java.design.patterns.behavioral.iterator.ChannelType;
import com.data.structures.algorithms.java.design.patterns.behavioral.mediator.ChatMediator;
import com.data.structures.algorithms.java.design.patterns.behavioral.mediator.ChatMediatorImpl;
import com.data.structures.algorithms.java.design.patterns.behavioral.mediator.User;
import com.data.structures.algorithms.java.design.patterns.behavioral.mediator.UserImpl;
import com.data.structures.algorithms.java.design.patterns.behavioral.memento.CareTaker;
import com.data.structures.algorithms.java.design.patterns.behavioral.memento.TextEditor;
import com.data.structures.algorithms.java.design.patterns.behavioral.observer.Observer;
import com.data.structures.algorithms.java.design.patterns.behavioral.observer.Topic;
import com.data.structures.algorithms.java.design.patterns.behavioral.observer.TopicSubscriber;
import com.data.structures.algorithms.java.design.patterns.behavioral.state.TVContext;
import com.data.structures.algorithms.java.design.patterns.behavioral.state.TVStartState;
import com.data.structures.algorithms.java.design.patterns.behavioral.state.TVStopState;
import com.data.structures.algorithms.java.design.patterns.behavioral.strategy.CreditCard;
import com.data.structures.algorithms.java.design.patterns.behavioral.strategy.Item;
import com.data.structures.algorithms.java.design.patterns.behavioral.strategy.PayPalProvider;
import com.data.structures.algorithms.java.design.patterns.behavioral.strategy.ShoppingCart;
import com.data.structures.algorithms.java.design.patterns.behavioral.template.GlassHouse;
import com.data.structures.algorithms.java.design.patterns.behavioral.template.HouseTemplate;
import com.data.structures.algorithms.java.design.patterns.behavioral.template.WoodenHouse;
import com.data.structures.algorithms.java.design.patterns.behavioral.visitor.*;
import com.data.structures.algorithms.java.design.patterns.creational.abstractfactory.WindowsFactory;
import com.data.structures.algorithms.java.design.patterns.creational.builder.BuilderPattern;
import com.data.structures.algorithms.java.design.patterns.creational.factory.Gui;
import com.data.structures.algorithms.java.design.patterns.creational.factory.GuiEnum;
import com.data.structures.algorithms.java.design.patterns.creational.factory.GuiFactory;
import com.data.structures.algorithms.java.design.patterns.creational.prototype.PrototypePattern;
import com.data.structures.algorithms.java.design.patterns.creational.singleton.EagerInitialization;
import com.data.structures.algorithms.java.design.patterns.creational.singleton.EnumSingleton;
import com.data.structures.algorithms.java.design.patterns.creational.singleton.LazyInitialization;
import com.data.structures.algorithms.java.design.patterns.structural.adapter.SocketAdapter;
import com.data.structures.algorithms.java.design.patterns.structural.adapter.SocketClassAdapterImpl;
import com.data.structures.algorithms.java.design.patterns.structural.adapter.SocketObjectAdapterImpl;
import com.data.structures.algorithms.java.design.patterns.structural.adapter.Volt;
import com.data.structures.algorithms.java.design.patterns.structural.bridge.AdvancedRemote;
import com.data.structures.algorithms.java.design.patterns.structural.bridge.Radio;
import com.data.structures.algorithms.java.design.patterns.structural.bridge.Remote;
import com.data.structures.algorithms.java.design.patterns.structural.bridge.TV;
import com.data.structures.algorithms.java.design.patterns.structural.composite.Circle;
import com.data.structures.algorithms.java.design.patterns.structural.composite.Drawing;
import com.data.structures.algorithms.java.design.patterns.structural.composite.Shape;
import com.data.structures.algorithms.java.design.patterns.structural.composite.Triangle;
import com.data.structures.algorithms.java.design.patterns.structural.decorator.BasicVideoStream;
import com.data.structures.algorithms.java.design.patterns.structural.decorator.DRMVideoStream;
import com.data.structures.algorithms.java.design.patterns.structural.decorator.SubtitledStream;
import com.data.structures.algorithms.java.design.patterns.structural.decorator.VideoStream;
import com.data.structures.algorithms.java.design.patterns.structural.facade.*;
import com.data.structures.algorithms.java.design.patterns.structural.flyweight.DrawingClient;
import com.data.structures.algorithms.java.design.patterns.structural.proxy.CommandExecutor;
import com.data.structures.algorithms.java.design.patterns.structural.proxy.CommandProxyExecutor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Creational

        // Singleton
        EnumSingleton singleton = EnumSingleton.INSTANCE;

        EagerInitialization.getInstance();
        LazyInitialization.getInstanceDoubleLocking();

        // Factory
        Gui mac = GuiFactory.getInstance(GuiEnum.MAC);
        // Abstract factory
        com.data.structures.algorithms.java.design.patterns.creational.abstractfactory.Gui windows = com.data.structures.algorithms.java.design.patterns.creational.abstractfactory.GuiFactory.getGui(new WindowsFactory());

        // builder
        BuilderPattern builder = BuilderPattern.getBuilder()
                .setValue1(1)
                .setValue2(2)
                .build();

        // Prototype
        PrototypePattern prototypePattern = new PrototypePattern();
        PrototypePattern prototypePattern1 = prototypePattern.clone();

        // -----------------------------------------------------------------------------------------------------------
        // Structural

        // Adapter
        SocketAdapter classSocketAdapter = new SocketClassAdapterImpl();
        Volt classVolt120 = classSocketAdapter.get120Volt();
        Volt classVolt12 = classSocketAdapter.get12Volt();
        Volt classVolt3 = classSocketAdapter.get3Volt();

        SocketAdapter objectSocketAdapter = new SocketObjectAdapterImpl();
        Volt objVolt120 = objectSocketAdapter.get120Volt();
        Volt objVolt12 = objectSocketAdapter.get12Volt();
        Volt objVolt3 = objectSocketAdapter.get3Volt();

        print(classVolt120.getVolt()); print(classVolt12.getVolt()); print(classVolt3.getVolt());
        print(objVolt120.getVolt()); print(objVolt12.getVolt()); print(objVolt3.getVolt());

        // Composite
        Shape tri = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Red");
        drawing.draw("green");
        drawing.clear();

        // Proxy

        CommandExecutor commandExecutor = new CommandProxyExecutor("Shanmuga", "wrong_z`pwd");
        commandExecutor.runCommand("rm abc.pdf");

        // Flyweight
//        new DrawingClient(500, 600);

        // Facade
        HomeTheatreFacade homeTheatreFacade = new HomeTheatreFacade(new DVDPlayer(), new Projector(), new Amplifier(), new Lights());
        homeTheatreFacade.watchMovie("Interstellar");
        homeTheatreFacade.endMovie();
        print("--------------------\n");

        // Bridge
        Remote remote = new Remote(new TV());
        remote.on();
        remote.setVolume(10);
        remote.off();

        AdvancedRemote advancedRemote = new AdvancedRemote(new Radio());
        advancedRemote.on();
        advancedRemote.mute();
        advancedRemote.off();

        // Decorator
        VideoStream basicStream = new BasicVideoStream();
        System.out.println("\n🔹 Basic Stream:");
        basicStream.play();

        // Add DRM Protection (Widevine)
        VideoStream drmStream = new DRMVideoStream(basicStream, "Widevine");
        System.out.println("\n🔹 DRM-Protected Stream:");
        drmStream.play();

        // Add DRM + Subtitles (English)
        VideoStream subtitleStream = new SubtitledStream(drmStream, "English");
        System.out.println("\n🔹 DRM + Subtitle Stream:");
        subtitleStream.play();


        // -----------------------------------------------------------------------------------------------------------
        // Behavioral

        // Template
        HouseTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();

        HouseTemplate glassHouse = new GlassHouse();
        glassHouse.buildHouse();


        // Mediator
        ChatMediator chatMediator = new ChatMediatorImpl();
        User shawn = new UserImpl(chatMediator, "Shawn");
        User mani = new UserImpl(chatMediator, "Mani");
        User sathya = new UserImpl(chatMediator, "Sathya");
        User vinodh = new UserImpl(chatMediator, "Vinodh");

        chatMediator.addUser(shawn);
        chatMediator.addUser(mani);
        chatMediator.addUser(sathya);
        chatMediator.addUser(vinodh);

        shawn.sendMessage("Hi All!!!");

        chatMediator.removeUser(vinodh);

        shawn.sendMessage("Bye All!!!");

        // Chain of responsibility
        FiftyDollarDispenser atmDispenser = new FiftyDollarDispenser();
        TwentyDollarDispenser twentyDollarDispenser = new TwentyDollarDispenser();
        TenDollarDispenser tenDollarDispenser = new TenDollarDispenser();

        atmDispenser.setNextChain(twentyDollarDispenser);
        twentyDollarDispenser.setNextChain(tenDollarDispenser);

        atmDispenser.dispense(new Currency(180));

        // Observer

        Topic topic = new Topic();

        Observer observer1 = new TopicSubscriber("obj1");
        Observer observer2 = new TopicSubscriber("obj2");
        Observer observer3 = new TopicSubscriber("obj3");


        topic.registerObserver(observer1);
        topic.registerObserver(observer2);
        topic.registerObserver(observer3);

        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        observer1.update();

        topic.postMessage("First message in the topic...");

        // Strategy eg. Collections.sort(), Arrays.sort()
        Item item1 = new Item("joystick", 120);
        Item item2 = new Item("keyboard", 60);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        shoppingCart.pay(new CreditCard("1111 1111 1111 1111", "12/28", "111"));

        shoppingCart.pay(new PayPalProvider("shan@test.com", "password"));

        // Command eg. Runnable
        FileSystemReceiver fs = FileSystemReceiverUtil.getFileSystemReceiver();

        Command command = new OpenFileCommand(fs);

        FileInvoker fileInvoker = new FileInvoker(command);
        fileInvoker.execute();

        fileInvoker = new FileInvoker(new CloseFileCommand(fs));
        fileInvoker.execute();

        // State
        TVContext tvContext = new TVContext();
        TVStartState tvStartState = new TVStartState();
        TVStopState tvStopState = new TVStopState();

        tvContext.setState(tvStartState);
        tvContext.doAction();

        tvContext.setState(tvStopState);
        tvContext.doAction();

        // Visitor
        ItemElement[] shoppingCartItems = new ItemElement[] {new Book(20, "123"),
                new Fruit(21, 1, "Banana"), new Fruit(25, 2, "Apple"), new Book(50, "456")};

        ShoppingCartVisitor shoppingCartVisitor = new ShoppingCartVisitorImpl();

        /* calculate prices */
        int sum = 0;
        for (ItemElement itemElement: shoppingCartItems) {
            sum += itemElement.accept(shoppingCartVisitor);
        }
        print(sum);

        // Iterator

        Channel english = new Channel(100.1, ChannelType.ENGLISH);
        Channel french = new Channel(100.7, ChannelType.FRENCH);
        Channel hindi = new Channel(101.7, ChannelType.HINDI);
        Channel all = new Channel(103.8, ChannelType.ALL);
        Channel english2 = new Channel(105.2, ChannelType.ENGLISH);

        ChannelCollectionImpl channelCollection = new ChannelCollectionImpl();
        channelCollection.addChannel(english);
        channelCollection.addChannel(french);
        channelCollection.addChannel(hindi);
        channelCollection.addChannel(all);
        channelCollection.addChannel(english2);

        ChannelIterator iterator = channelCollection.iterator(ChannelType.ENGLISH);

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Memento
        TextEditor textEditor = new TextEditor();
        CareTaker careTaker = new CareTaker();

        textEditor.write("First sentence");
        careTaker.saveState(textEditor);

        textEditor.write("Second sentence");
        careTaker.saveState(textEditor);

        textEditor.write("Third Sentence");

        careTaker.undo(textEditor);
        System.out.println(textEditor.getContent());

        careTaker.undo(textEditor);
        System.out.println(textEditor.getContent());
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}
