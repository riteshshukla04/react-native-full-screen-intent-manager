# react-native-full-screen-intent-manager

A package to manage full screen intents in React Native

## Installation

```sh
npm install react-native-full-screen-intent-manager
```

## Usage


```js
import {
  requestFullScreenIntentPermission,
  canUseFullScreenIntent,
} from 'react-native-full-screen-intent-manager';


// Check Full Screen Permission
const result = await canUseFullScreenIntent();


//get Full Screen Permission
const result = await requestFullScreenIntentPermission();


```


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
