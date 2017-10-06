# messenger4j: A Java library for the Messenger Platform

If you are excited about building Chatbots on the Facebook Messenger Platform, messenger4j is all you need ✌

>It's fast, lightweight, feature-rich, and easy to use.

For more information on the Facebook Messenger Platform refer to the [official documentation][1].

## Thanks original messenger4j

This is a project-based API [Original Messenger 4j](https://github.com/messenger4j/messenger4j/)

I checked some problems and as the original API was not maintained and the last commit was old, I decided to make a fork and improve gradually.

I included the same in [Sonarcloud](https://sonarcloud.io/dashboard?id=br.com.digidev.messenger4j%3Amessenger4j), github and [Travis CI](https://travis-ci.org/digidevbr/messenger4j) for build tracking.

I will improve the documentation, and any problems, feel free to open a issue or perform a pull request.

## Build Status
[![Build Status](https://travis-ci.org/digidevbr/messenger4j.svg?branch=master)](https://travis-ci.org/digidevbr/messenger4j)

## Bintray Status
<a href='https://bintray.com/digidevbr/messenger4j/messenger4j?source=watch' alt='Get automatic notifications about new "messenger4j" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>

## Analysis of messenger4j Project

[![sonar-quality-gate][sonar-quality-gate]][sonar-url]
[![sonar-coverage][sonar-coverage]][sonar-url]
[![sonar-bugs][sonar-bugs]][sonar-url]
[![sonar-vulnerabilities][sonar-vulnerabilities]][sonar-url]

[sonar-url]: https://sonarcloud.io/dashboard?id=br.com.digidev.messenger4j%3Amessenger4j
[sonar-quality-gate]: https://sonarcloud.io/api/badges/gate?key=br.com.digidev.messenger4j%3Amessenger4j
[sonar-coverage]: https://sonarcloud.io/api/badges/measure?key=br.com.digidev.messenger4j%3Amessenger4j&metric=coverage
[sonar-bugs]: https://sonarcloud.io/api/badges/measure?key=br.com.digidev.messenger4j%3Amessenger4j&metric=bugs
[sonar-vulnerabilities]: https://sonarcloud.io/api/badges/measure?key=br.com.digidev.messenger4j%3Amessenger4j&metric=vulnerabilities

## Features
* Full supported Receive API
    + Webhook verification
    + Signature verification
    + Automatic message / event type detection
    + Handler-based processing of messages / events
    + Fallback-mechanisms
* Full supported Send API
    + Text, Attachments, Buttons, Templates, Quick Replies - everything you need
    + Notification type support
    + Webview support
    + Fluent builder APIs
    + Pluggable HTTP-Client (`okHttp` is the default)
* Thread Settings support
    + Get Started Button
    + Greeting Text
    + Persistent Menu
* User Profile API support
* Messenger Extensions support
* JDK 7+ compatible
* JDK 8 lambda support
* 3 dependencies:
    + slf4j-api
    + gson
    + okHttp (optional)
* 150 kB JAR


## Binaries
To add a dependency on messenger4j using Maven, use the following:

```xml
<dependency>
  <groupId>br.com.digidev.messenger4j</groupId>
  <artifactId>messenger4j</artifactId>
  <version>0.1.0</version>
</dependency>
```
To add a dependency using Gradle:

```
dependencies {
  compile 'br.com.digidev.messenger4j:messenger4j:0.1.0'
}
```

##Repositories

Note: 
We are putting the dependencies in the maven central, however, until then it is necessary to include the repositories in your application or settings in maven.

Add repository in pom or settings.xml
```xml
    <repositories>
        <repository>
            <id>digidev</id>
            <name>digidev - repository</name>
            <url>https://dl.bintray.com/digidevbr/messenger4j/</url>
        </repository>
    </repositories>
```    

Add Repository in gradle

``` 
repositories {
    digidev {
        url "https://dl.bintray.com/digidevbr/messenger4j"
    }
}
```

## Examples
> For almost all supported features you can take a look at the integration tests (`src/test/java/.../test/integration`) for a working example.

#### Receiving
Let's see how to handle an inbound text message:

```java
String payload = ... // callback request body
String signature = ... // 'X-Hub-Signature' request header

// JDK 8 version
MessengerReceiveClient receiveClient = MessengerPlatform.newReceiveClientBuilder("APP_SECRET", "VERIFICATION_TOKEN")
        .onTextMessageEvent(event ->  System.out.printf("%s: %s", event.getSender().getId(), event.getText()))
        .build();

// JDK 7 version
MessengerReceiveClient receiveClient = MessengerPlatform.newReceiveClientBuilder("APP_SECRET", "VERIFICATION_TOKEN")
        .onTextMessageEvent(new TextMessageEventHandler() {
            @Override
            public void handle(TextMessageEvent event) {
                System.out.printf("%s: %s", event.getSender().getId(), event.getText());
            }
        })
        .build();

receiveClient.processCallbackPayload(payload, signature);
```

But what if you are receiving an image / video / ... attachment?

Either register an `AttachmentMessageEventHandler` as well:
```java
MessengerReceiveClient receiveClient = MessengerPlatform.newReceiveClientBuilder("APP_SECRET", "VERIFICATION_TOKEN")
        .onTextMessageEvent(event -> {
            System.out.printf("%s: %s", event.getSender().getId(), event.getText());
        })
        .onAttachmentMessageEvent(event -> {
            event.getAttachments().forEach(attachment -> System.out.println(attachment.getType()));
        })
        .build();
```
or register a `FallbackEventHandler` that handles all inbound messages or events for which no `EventHandler` has been registered:
```java
MessengerReceiveClient receiveClient = MessengerPlatform.newReceiveClientBuilder("APP_SECRET", "VERIFICATION_TOKEN")
        .onTextMessageEvent(event -> {
            System.out.printf("%s: %s", event.getSender().getId(), event.getText());
        })
        .fallbackEventHandler(event -> {
            System.out.printf("%s: Sorry, cannot handle your request!" + event.getSender().getId());
        })
        .build();
```

In addition the following handlers are supported: 
* `AccountLinkingEventHandler`
* `EchoMessageEventHandler`
* `MessageDeliveredEventHandler`
* `MessageReadEventHandler`
* `OptInEventHandler`
* `PostbackEventHandler`
* `QuickReplyMessageEventHandler`

#### Sending
What's about sending messages back to the user?

Sending a text message is as simple as: 

```java
MessengerSendClient sendClient = MessengerPlatform.newSendClientBuilder("PAGE_ACCESS_TOKEN").build();
sendClient.sendTextMessage("RECIPIENT_ID", "Hi there, how are you today?");
```
And if you want to add `Quick Replies` to your response, just do the following:
```java
List<QuickReply> quickReplies = QuickReply.newListBuilder()
        .addTextQuickReply("great", "GREAT_PAYLOAD").toList()
        .addTextQuickReply("brilliant", "BRILLIANT_PAYLOAD").imageUrl("http://thumb-up-image.url").toList()
        .addLocationQuickReply().toList()
        .build();
        
sendClient.sendTextMessage("RECIPIENT_ID", "Hi there, how are you today?", quickReplies);
```

And of course - `Templates`. Creating them using the fluent builder API is super easy:
```java
ReceiptTemplate receipt = ReceiptTemplate.newBuilder("Stephane Crozatier", "12345678902", "USD", "Visa 2345")
        .orderUrl("http://petersapparel.parseapp.com/order?order_id=123456")
        .timestamp(1428444852L)
        .addElements()
            .addElement("Classic White T-Shirt", 50F)
                .subtitle("100% Soft and Luxurious Cotton")
                .quantity(2)
                .currency("USD")
                .imageUrl("http://petersapparel.parseapp.com/img/whiteshirt.png")
                .toList()
            .addElement("Classic Gray T-Shirt", 25F)
                .subtitle("100% Soft and Luxurious Cotton")
                .quantity(1)
                .currency("USD")
                .imageUrl("http://petersapparel.parseapp.com/img/grayshirt.png")
                .toList()
            .done()
        .addAddress("1 Hacker Way", "Menlo Park", "94025", "CA", "US").street2("").done()
        .addSummary(56.14F).subtotal(75.00F).shippingCost(4.95F).totalTax(6.19F).done()
        .addAdjustments()
            .addAdjustment()
                .name("New Customer Discount")
                .amount(20.00F)
                .toList()
            .addAdjustment()
                .name("$10 Off Coupon")
                .amount(10.00F)
            .toList()
        .done()
        .build();
        
sendClient.sendTemplate("RECIPIENT_ID", receipt);
```
```java
List<Button> buttons = Button.newListBuilder()
        .addUrlButton("View Website", "https://petersfancybrownhats.com").toList()
        .addPostbackButton("Start Chatting", "DEVELOPER_DEFINED_PAYLOAD").toList()
        .build();

GenericTemplate genericTemplate = GenericTemplate.newBuilder()
        .addElements()
            .addElement("Welcome to Peters Hats")
                .itemUrl("https://petersfancybrownhats.com")
                .imageUrl("https://petersfancybrownhats.com/company_image.png")
                .subtitle("We have got the right hat for everyone.")
                .buttons(buttons)
                .toList()
        .done()
        .build();

sendClient.sendTemplate("RECIPIENT_ID", genericTemplate);
```

In addition the following methods are available:
* `sendSenderAction`
* `sendImageAttachment`
* `sendAudioAttachment`
* `sendVideoAttachment`
* `sendFileAttachment`
* `sendBinaryAttachment` - for reusable attachments

#### The Echo Example
```java
MessengerSendClient sendClient = MessengerPlatform.newSendClientBuilder("PAGE_ACCESS_TOKEN").build();
        
MessengerReceiveClient receiveClient = MessengerPlatform.newReceiveClientBuilder("APP_SECRET", "VERIFICATION_TOKEN")
        .onTextMessageEvent(event -> {
            try {
                sendClient.sendTextMessage(event.getSender().getId(), "Echo: " + event.getText());
            } catch (MessengerApiException | MessengerIOException e) {
                // Oops, something went wrong
            }
        })
        .build();

receiveClient.processCallbackPayload(payload, signature);
```

## Things to do
Unordered list of planned improvements: 
* comprehensive documentation
* Receive API:
    + Referral support
* Send API: 
    + JavaDoc
    + Airline Templates
    + *upload* Binary Attachments
* Payment support
* Checkbox Plugin support

## License
This project is licensed under the terms of the [MIT license](LICENSE).


[1]: https://developers.facebook.com/docs/messenger-platform
