import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-full-screen-intent-manager' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const FullScreenIntentManager = NativeModules.FullScreenIntentManager
  ? NativeModules.FullScreenIntentManager
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function requestFullScreenIntentPermission() {
  if (Platform.OS === 'android') {
    FullScreenIntentManager.openFullScreenIntentSettings();
  }
}

export function canUseFullScreenIntent() {
  if (Platform.OS === 'android') {
    return FullScreenIntentManager.hasFullScreenIntentPermission();
  }
}
