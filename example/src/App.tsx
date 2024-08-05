import { useState, useEffect } from 'react';
import { StyleSheet, View, Text } from 'react-native';
import {
  requestFullScreenIntentPermission,
  canUseFullScreenIntent,
} from 'react-native-full-screen-intent-manager';

export default function App() {
  const [result, setResult] = useState<boolean>(false);
  const checkPermission = async () => {
    const hasPermision = await canUseFullScreenIntent();
    setResult(hasPermision);
    if (!hasPermision) {
      requestFullScreenIntentPermission();
    }
  };

  useEffect(() => {
    checkPermission();
  }, []);

  return (
    <View style={styles.container}>
      <Text>Has permission: {`${result}`}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
