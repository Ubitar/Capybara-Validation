## Capybara-Validator 
An android bean validator library
Make your code structure more standardized


- support quick check mode
- support custom rule
- support android string resource
### Import
```implementation 'com.ubitar.capybara:validator:1.0.1'```
### Use
**1、Create your bean**
```
public class RawBean1 {
    private String str;
    //some setter and getter
}
```
**2、Create the Validation Class**
```
public class RawValidation1 extends BaseValidation<RawBean1> {
    public RawValidation1(RawBean1 rawBean1) {
        super(rawBean1);
    }

    @Override
    public IResult<RawBean1> onValid(IComparator<RawBean1> comparator) {
        RawBean1 rawBean1 = getRaw();
        //Context context=getContext();
        return comparator
                //add the validation rule
                .addItem(new NotNullRule(rawBean1.getStr(), "str can't not be null","tag1"))
                .validate();//begin
    }
}
```
**3、Begin**
```
IResult result = CValidator.valid(new RawValidation1(bean));
//get the first reason for the error
IReason reason = result.getReasonAtFirst();
//get the error reason message
String message = reason.getMessage();
//get the rule 、tag and target field
IFieldRule<Object> rule = (IFieldRule<Object>) reason.getRule();
String tag = rule.getTag();
Object field = rule.getField();
```
```
//QuickMode
CValidator.valid(Raw bean,Boolean quickMode)
//get all reason
List<IReason> reasons = result.getAllReason();
```
**4、There are more standard rule in the library**<br/>
EmailRule、EqualsRule、LengthRule、MaxLengthRule、MinLengthRule、MaxRule、MinRule、NotEmptyRule、NotNullRule、NotSpaceRule、UrlRule
### Advanced  
**5、Maybe you want to customize the rules in your project. Such as phone rule**
```
public class PhoneRule extends BaseRule<String> {

    private String message;

    public PhoneRule(@Nullable String field, String message) {
        super(field);
        this.message = message;
    }

    /**
     * your custom valid
     *
     * @return true :pass valid    false:unpass
     */
    @Override
    public boolean onMatchField(String field) {
        if (field == null||field.length()<=0) return false;
        return Pattern.matches( "^[1]\\d{10}$", field);
    }

    // your can get the error message after the verification fails
    @Override
    public String getMessage() {
        return message;
    }

    // your can get the tag after the verification fails
    @Override
    public String getTag() {
        return tag;
    }
}
```
**Use your rule**
```
comparator.addItem(new PhoneRule(rawBean.getPhone(),"Wrong phone number format"))
```
