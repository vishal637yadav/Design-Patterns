# State Design Pattern :
## 1) What Is the State Pattern ?
### **Intent:** 
Allow an object to alter its behavior when its internal state changes. The object appears to change its class.
### When to use:
1. Complex conditional logic based on an internal state.
2. State-specific behavior and transitions.
3. Need to add new states without modifying core logic (Open/Closed).

## 2) Structure (Participants)
### 1. Context
* Holds a reference to a State object.
* Delegates behavior to the current State.
### 2. State (interface/abstract)
* Declares state-specific operations.
### 3. ConcreteStateA, ConcreteStateB, ...
* Implement behavior for a particular state.
* Optionally decide state transitions by setting a new state in the Context.

## Example : Traffic-Light
### State interface
      interface LightState {
         void onTimer(TrafficLight ctx);
         String name();
      }

### Context
      class TrafficLight {
         private LightState state;
         
         public TrafficLight(LightState initial) {
            this.state = initial;
         }

         public void setState(LightState s) {
            this.state = s; 
         }

         public String getStateName() {
            return state.name(); 
         }
      
         // Event coming from a timer tick (end of interval)
         public void timerElapsed() {
            state.onTimer(this);
         }
      }

### Concrete states ::==>>
      class RedState implements LightState {
         
         public void onTimer(TrafficLight ctx) {
            System.out.println("Red → Green");
            ctx.setState(new GreenState());
         }
         
         public String name() {
            return "RED"; 
         }
      }

      class GreenState implements LightState {
         public void onTimer(TrafficLight ctx) {
            System.out.println("Green → Yellow");
            ctx.setState(new YellowState());
         }
         public String name() { return "GREEN"; }
      }

      class YellowState implements LightState {
         public void onTimer(TrafficLight ctx) {
            System.out.println("Yellow → Red");
            ctx.setState(new RedState());
         }
         public String name() { return "YELLOW"; }
      }

### Demo
      public class Main {
         public static void main(String[] args) {
            TrafficLight tl = new TrafficLight(new RedState());
            for (int i = 0; i < 5; i++) {
               System.out.println("Current: " + tl.getStateName());
               tl.timerElapsed();
            }
         }
      }

### Example of State Design Pattern
1. **Media Player** : 
   * **States :** Stopped, Playing, Paused  
   * **Events:** play(), pause(), stop(), next(), prev(). 
Each state defines what each event means.

###  Advantages
1. Removes large conditional blocks; behavior local to states.
2. Open/Closed: add new states without changing existing ones.
3. Clear transitions and testable units.

### Drawbacks
1. More classes and indirection.
2. Transitions scattered across states if not centralized (can use a transition table if needed).
## Variations and Tips
1. **Stateless singletons:** Make each ConcreteState a singleton to reduce allocations.
2. **Externalize transitions:** Keep transition table in Context if you prefer central control.
3. **Event-driven:** Define events as methods or a single handle(event) with an enum.
4. **Thread-safety:** Synchronize state changes if Context is shared.
5. **Logging/telemetry:** Log transitions inside setState for observability.

## When Not To Use
1. If states are few and logic is trivial, simple conditionals may be clearer.
2. If transitions are purely data-driven with no state-specific behavior, consider a finite-state machine table or a strategy.

## Common Example of State Design Pattern :
1. Order/Workflow Lifecycles (e-commerce, ERP)
States: New → Paid → Packed → Shipped → Delivered → Returned/Cancelled
Behavior varies by state:
New: allow payment, allow cancel
Shipped: disallow address change, allow delivery tracking
Delivered: allow return request within window
2. Document Processing and Approvals (DMS, HR, Legal)

States: Draft → InReview → Approved → Published → Archived
Behavior:
Draft: editable
InReview: read-only to author, approvers can comment/approve
Approved: lock editing, allow publish
Archived: read-only, no further transitions except restore
3. Authentication/Session Management
States: LoggedOut → LoggingIn → Authenticated → Locked → Expired
Behavior:
LoggedOut: show login form
Authenticated: access protected resources
Locked: require MFA/unlock flow
Expired: redirect to re-authenticate
4. Payment/Transaction State Machines
States: Initiated → Authorized → Captured → Settled → Refunded → Failed
Behavior:
Authorized: can capture or void
Captured: can refund (full/partial)
Failed: show retry/alternate payment
5. Media Player or IoT Device Controls
States: Stopped → Playing → Paused → Buffering → Error
Behavior:
Playing: respond to pause/stop
Buffering: disable seek or show spinner
Error: show retry/reload
6. Finite-State UI Components and Wizards
States: Step1 → Step2 → Step3 → Completed
Behavior:
Each step validates inputs and controls navigation
Disabled/enabled buttons depend on current step
7. Shopping Cart State
States: Empty → Active → CheckedOut → Abandoned
Behavior:
Empty: disable checkout
Active: allow add/remove, apply coupons
CheckedOut: lock changes, generate order
8. Ticketing/Issue Tracking (Jira-like)
States: Open → InProgress → InReview → Done → Reopened → Closed
Behavior:
Transitions gated by role and checks (e.g., tests passing)
Notifications/actions differ per state
9. Network Connection/Retry Logic
States: Disconnected → Connecting → Connected → Backoff → Failed
Behavior:
Backoff: exponential wait before retry
Connected: send/receive; on error transition to Connecting
10. Manufacturing/Workflow Machines
States: Idle → Setup → Running → Maintenance → Fault
Behavior:
Running: process jobs
Fault: stop, alert, only maintenance actions allowed
11. Content Subscription/Licensing

States: Trial → Active → Grace → Suspended → Cancelled
Behavior:
Grace: reduced features, reminders
Suspended: block premium features, allow payment
12. Email/SMS Campaign Sending

States: Draft → Scheduled → Sending → Paused → Completed → Failed
Behavior:
Paused: allow resume/cancel
Sending: throttle, handle bounces
When to Prefer State Pattern
[1] Indicators it fits:

Many conditional branches based on a state field.
Each state has unique rules/allowed operations.
Transitions are explicit and finite.
You need to add new states without modifying a massive class.
[2] Indicators to avoid:

Only two trivial states with minimal behavior difference.
Behavior doesn’t depend on internal state but on inputs alone (use Strategy).
Design Tips
[1] Model a clear interface for actions

Example: for Orders: pay(), ship(), cancel(), refund()
[2] Keep transitions within state objects

Each state decides valid next state and throws on invalid actions.
[3] Combine with a state machine or workflow engine for complex graphs

Useful for auditing, visualization, and dynamic transitions.
[4] Persist state

Store current state key; reconstruct the state object on load.
[5] Side effects and domain events

Emit events on transitions (e.g., OrderShipped) to decouple notifications/integrations.
Minimal Code Sketch (Java + Spring Boot)
[1] Interfaces and States

java

public interface OrderState {
void pay(Order ctx);
void ship(Order ctx);
void cancel(Order ctx);
String name();
}

public class NewState implements OrderState {
public void pay(Order ctx) { ctx.setState(new PaidState()); }
public void ship(Order ctx) { throw new IllegalStateException("Pay first"); }
public void cancel(Order ctx) { ctx.setState(new CancelledState()); }
public String name() { return "NEW"; }
}

public class PaidState implements OrderState {
public void pay(Order ctx) { /* idempotent */ }
public void ship(Order ctx) { ctx.setState(new ShippedState()); }
public void cancel(Order ctx) { throw new IllegalStateException("Already paid"); }
public String name() { return "PAID"; }
}
[2] Context and Persistence

java

public class Order {
private OrderState state = new NewState();
private String stateCode = "NEW";

    public void setState(OrderState state) {
        this.state = state;
        this.stateCode = state.name();
        // emit domain event, persist stateCode
    }
    // delegate methods
    public void pay() { state.pay(this); }
    public void ship() { state.ship(this); }
    public void cancel() { state.cancel(this); }
}
Testing and Evolution
[1] Unit-test each state’s allowed/forbidden actions.
[2] Adding a new state involves creating a class and wiring transitions, with minimal changes to existing code.

If you share your domain (e.g., payments, workflow, device control), I can map concrete states and transitions tailored to your application.

Copy
Like
Dislike


┌─────────────────────────┐
│       Context           │
├─────────────────────────┤
│ - state: State          │
│ - data: String          │
├─────────────────────────┤
│ + setState(State)       │
│ + request()             │
│ + getData()             │
│ + setData(String)       │
└─────────────────────────┘
            │
            ▼
┌─────────────────────────┐
│     <<interface>>       │
│        State            │
├─────────────────────────┤
│ + handle(Context)       │
└─────────────────────────┘
△
         │
┌────────│───────┐
▼               ▼
┌─────────────┐ ┌─────────────┐
│ConcreteStateA│ │ConcreteStateB│
├─────────────┤ ├─────────────┤
│+ handle()   │ │+ handle()   │
└─────────────┘ └─────────────┘

