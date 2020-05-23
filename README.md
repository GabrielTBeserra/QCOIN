# qcoin

### Import

```java
public class CoinImport {
    public static QCoinAPI getWorldGuardPlugin() {
        Plugin wg = plugin.getServer().getPluginManager().getPlugin("QCoin");


        if (wg == null || !(wg instanceof QCoinAPI)) {
            return null;
        }

        return (QCoinAPI) wg;
    }
}
```
