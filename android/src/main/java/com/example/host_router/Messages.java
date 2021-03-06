// Autogenerated from Pigeon (v0.1.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon


import java.util.HashMap;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;

/** Generated class from Pigeon. */
public class Messages {

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class PushRoute {
    private String name;
    public String getName() { return name; }
    public void setName(String setterArg) { this.name = setterArg; }

    HashMap toMap() {
      HashMap<String, Object> toMapResult = new HashMap<String, Object>();
      toMapResult.put("name", name);
      return toMapResult;
    }
    static PushRoute fromMap(HashMap map) {
      PushRoute fromMapResult = new PushRoute();
      fromMapResult.name = (String)map.get("name");
      return fromMapResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class PopRoute {
    private String name;
    public String getName() { return name; }
    public void setName(String setterArg) { this.name = setterArg; }

    HashMap toMap() {
      HashMap<String, Object> toMapResult = new HashMap<String, Object>();
      toMapResult.put("name", name);
      return toMapResult;
    }
    static PopRoute fromMap(HashMap map) {
      PopRoute fromMapResult = new PopRoute();
      fromMapResult.name = (String)map.get("name");
      return fromMapResult;
    }
  }

  /** Generated class from Pigeon that represents Flutter messages that can be called from Java.*/
  public static class FlutterRouterApi {
    private BinaryMessenger binaryMessenger;
    public FlutterRouterApi(BinaryMessenger argBinaryMessenger){
      this.binaryMessenger = argBinaryMessenger;
    }
    public interface Reply<T> {
      void reply(T reply);
    }
    public void pushRoute(PushRoute argInput, Reply<Void> callback) {
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<Object>(binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.pushRoute", new StandardMessageCodec());
      HashMap inputMap = argInput.toMap();
      channel.send(inputMap, new BasicMessageChannel.Reply<Object>() {
        public void reply(Object channelReply) {
          callback.reply(null);
        }
      });
    }
    public void popRoute(Reply<Void> callback) {
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<Object>(binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.popRoute", new StandardMessageCodec());
      channel.send(null, new BasicMessageChannel.Reply<Object>() {
        public void reply(Object channelReply) {
          callback.reply(null);
        }
      });
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter.*/
  public interface HostRouterApi {
    void pushHostRoute(PushRoute arg);
    void pushFlutterRoute(PushRoute arg);
    void popRoute(PopRoute arg);

    /** Sets up an instance of `HostRouterApi` to handle messages through the `binaryMessenger` */
    public static void setup(BinaryMessenger binaryMessenger, HostRouterApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<Object>(binaryMessenger, "dev.flutter.pigeon.HostRouterApi.pushHostRoute", new StandardMessageCodec());
        if (api != null) {
          channel.setMessageHandler(new BasicMessageChannel.MessageHandler<Object>() {
            public void onMessage(Object message, BasicMessageChannel.Reply<Object> reply) {
              PushRoute input = PushRoute.fromMap((HashMap)message);
              HashMap<String, HashMap> wrapped = new HashMap<String, HashMap>();
              try {
                api.pushHostRoute(input);
                wrapped.put("result", null);
              }
              catch (Exception exception) {
                wrapped.put("error", wrapError(exception));
              }
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<Object>(binaryMessenger, "dev.flutter.pigeon.HostRouterApi.pushFlutterRoute", new StandardMessageCodec());
        if (api != null) {
          channel.setMessageHandler(new BasicMessageChannel.MessageHandler<Object>() {
            public void onMessage(Object message, BasicMessageChannel.Reply<Object> reply) {
              PushRoute input = PushRoute.fromMap((HashMap)message);
              HashMap<String, HashMap> wrapped = new HashMap<String, HashMap>();
              try {
                api.pushFlutterRoute(input);
                wrapped.put("result", null);
              }
              catch (Exception exception) {
                wrapped.put("error", wrapError(exception));
              }
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<Object>(binaryMessenger, "dev.flutter.pigeon.HostRouterApi.popRoute", new StandardMessageCodec());
        if (api != null) {
          channel.setMessageHandler(new BasicMessageChannel.MessageHandler<Object>() {
            public void onMessage(Object message, BasicMessageChannel.Reply<Object> reply) {
              PopRoute input = PopRoute.fromMap((HashMap)message);
              HashMap<String, HashMap> wrapped = new HashMap<String, HashMap>();
              try {
                api.popRoute(input);
                wrapped.put("result", null);
              }
              catch (Exception exception) {
                wrapped.put("error", wrapError(exception));
              }
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  private static HashMap wrapError(Exception exception) {
    HashMap<String, Object> errorMap = new HashMap<String, Object>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", null);
    errorMap.put("details", null);
    return errorMap;
  }
}
